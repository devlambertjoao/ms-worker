package com.lambert.payroll.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lambert.payroll.dto.WorkerDTO;

@Component
@FeignClient(name = "ms-worker", path = "/api/worker/")
public interface WorkerFeignClient {

	@GetMapping(path = "{id}")
	ResponseEntity<WorkerDTO> findOne(@PathVariable(value = "id") Long id);
}
