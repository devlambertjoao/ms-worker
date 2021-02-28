package com.lambert.payroll.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambert.payroll.dto.WorkerDTO;
import com.lambert.payroll.exception.ResourceNotFoundException;
import com.lambert.payroll.feignclient.WorkerFeignClient;
import com.lambert.payroll.service.PayrollService;

@Service
public class PayrollServiceImpl implements PayrollService {

	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	@Override
	public WorkerDTO calculate(Long workerId) throws ResourceNotFoundException {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId.toString());
		WorkerDTO worker = workerFeignClient.findOne(workerId).getBody();
		if(worker == null) {
			throw new ResourceNotFoundException("Worker not found!");
		}
		final Float DISCOUNT_PERCENT = 0.2f;
		worker.setTotalIcome(worker.getWorkedHours() * worker.getIncomePerHour() * (1 - DISCOUNT_PERCENT));
		return worker;
	}

}
