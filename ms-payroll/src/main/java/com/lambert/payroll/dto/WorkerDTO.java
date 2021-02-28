package com.lambert.payroll.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WorkerDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Date birthday;
	private Float incomePerHour;
	private Float workedHours;
	private Float totalIcome;
}
