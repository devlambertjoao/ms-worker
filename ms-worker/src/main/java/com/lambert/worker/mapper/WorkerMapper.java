package com.lambert.worker.mapper;

import org.springframework.stereotype.Component;

import com.lambert.worker.data.mssql.entity.WorkerEntity;
import com.lambert.worker.dto.WorkerDTO;

@Component
public class WorkerMapper {

	public WorkerDTO toDTO(WorkerEntity entity) {
		WorkerDTO dto = new WorkerDTO();
		dto.setId(entity.getId());
		dto.setCreatedAt(entity.getCreatedAt());
		dto.setUpdatedAt(entity.getUpdatedAt());
		dto.setName(entity.getName());
		dto.setIncomePerHour(entity.getIncomePerHour());
		dto.setBirthday(entity.getBirthday());
		dto.setWorkedHours(entity.getWorkedHours());
		
		return dto;
	}
	
	public WorkerEntity toEntity(WorkerEntity entity, WorkerDTO dto) {
		entity.setName(dto.getName());
		entity.setIncomePerHour(dto.getIncomePerHour());
		entity.setBirthday(dto.getBirthday());
		entity.setWorkedHours(dto.getWorkedHours());
		
		return entity;
	}
}
