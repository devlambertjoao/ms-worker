package com.lambert.payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lambert.payroll.exception.ResourceNotFoundException;
import com.lambert.payroll.service.PayrollService;

@RestController
@RequestMapping(value = "/payroll")
public class PayrollController {

	@Autowired
	private PayrollService payrollService;

	@GetMapping
	public ResponseEntity<Object> calculate(@RequestParam("workerId") Long workerId) throws ResourceNotFoundException {
		try {
			return new ResponseEntity<>(payrollService.calculate(workerId), HttpStatus.OK);
		} catch (ResourceNotFoundException rnfe) {
			return new ResponseEntity<>(rnfe.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
