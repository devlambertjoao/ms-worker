package com.lambert.payroll.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambert.payroll.dto.WorkerDTO;
import com.lambert.payroll.exception.ResourceNotFoundException;
import com.lambert.payroll.feignclient.WorkerFeignClient;
import com.lambert.payroll.service.PayrollService;

import feign.FeignException;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class PayrollServiceImpl implements PayrollService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	@Bulkhead(name = "ms-payroll")
	@CircuitBreaker(name = "ms-payroll", fallbackMethod = "calculateFallback")
	@Override
	public WorkerDTO calculate(Long workerId) throws ResourceNotFoundException {
		WorkerDTO worker = workerFeignClient.findOne(workerId).getBody();
		if (worker == null) {
			throw new ResourceNotFoundException("Worker not found!");
		}
		final float DISCOUNT_PERCENT = 0.2f;
		worker.setTotalIcome(worker.getWorkedHours() * worker.getIncomePerHour() * (1 - DISCOUNT_PERCENT));
		return worker;
	}

	@SuppressWarnings("unused")
	private WorkerDTO calculateFallback(Exception ex) throws ResourceNotFoundException {
		if (ex instanceof FeignException) {
			throw new ResourceNotFoundException("Service unavailable!");
		}
		return null;
	}
}
