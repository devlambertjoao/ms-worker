package com.lambert.payroll.config;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.lambert.payroll.exception.ResourceNotFoundException;

import feign.FeignException.FeignClientException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

@Configuration
public class CircuitBreakerClientConfig {

	private static final Logger logger = LoggerFactory.getLogger(CircuitBreakerConfig.class);

	private final CircuitBreakerRegistry circuitBreakerRegistry;

	public CircuitBreakerClientConfig(CircuitBreakerRegistry circuitBreakerRegistry) {
		this.circuitBreakerRegistry = circuitBreakerRegistry;
	}

	@PostConstruct
	public void init() {
		CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom().failureRateThreshold(50)
				.slowCallRateThreshold(50).waitDurationInOpenState(Duration.ofMillis(1000))
				.slowCallDurationThreshold(Duration.ofSeconds(2)).permittedNumberOfCallsInHalfOpenState(3)
				.minimumNumberOfCalls(10).slidingWindowType(SlidingWindowType.TIME_BASED).slidingWindowSize(5)
//				.recordException(e -> HttpStatus.INTERNAL_SERVER_ERROR.equals(e.get)) can check exception
				.recordExceptions(FeignClientException.class, TimeoutException.class)
				.ignoreExceptions(ResourceNotFoundException.class).build();

		CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("ms-payroll", circuitBreakerConfig);
		circuitBreaker.getEventPublisher().onStateTransition(event -> {
			CircuitBreaker.StateTransition transition = event.getStateTransition();
			logger.info("Circuit breaker 'mycircuitbreaker' state change: {} !!!", transition);
		});
	}

}
