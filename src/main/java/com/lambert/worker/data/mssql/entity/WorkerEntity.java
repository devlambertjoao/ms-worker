package com.lambert.worker.data.mssql.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_WORKER")
public class WorkerEntity extends BaseEntity {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Date birthday;
	private Float incomePerHour;
	private Float workedHours;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="BIRTHDAY")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Column(name="INCOME_PER_HOUR")
	public Float getIncomePerHour() {
		return incomePerHour;
	}
	public void setIncomePerHour(Float incomePerHour) {
		this.incomePerHour = incomePerHour;
	}
	
	@Column(name="WORKED_HOURS")
	public Float getWorkedHours() {
		return workedHours;
	}
	public void setWorkedHours(Float workedHours) {
		this.workedHours = workedHours;
	}
	
}
