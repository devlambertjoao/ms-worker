package com.lambert.payroll.service.impl;

import org.springframework.stereotype.Service;

import com.lambert.payroll.service.PayrollService;

@Service
public class PayrollServiceImpl implements PayrollService {

	@Override
	public Float calculate(Float workedHours, Float incomePerHour) {
		final Float DISCOUNT_PERCENT = 0.2f;
		Float totalIncome = workedHours * incomePerHour;
		
		return totalIncome * (1 - DISCOUNT_PERCENT);
	}

}
