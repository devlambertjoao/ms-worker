package com.lambert.payroll.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = { "com.lambert.payroll.feignclient" })
@Configuration
public class FeignClientConfig {

}
