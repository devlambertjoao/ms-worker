package com.lambert.payroll.service;

import com.lambert.payroll.dto.WorkerDTO;
import com.lambert.payroll.exception.ResourceNotFoundException;

public interface PayrollService {
	
	WorkerDTO calculate(Long workerId) throws ResourceNotFoundException;
}
