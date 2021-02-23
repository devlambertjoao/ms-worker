package com.lambert.worker.mapper;

import org.springframework.stereotype.Component;

import com.lambert.worker.data.mssql.entity.WorkerEntity;
import com.lambert.worker.dto.WorkerDTO;

@Component
public class WorkerMapper {

	public WorkerDTO toDTO(WorkerEntity workerEntity) {
		WorkerDTO workerDTO = new WorkerDTO();
		workerDTO.setId(workerEntity.getId());
		workerDTO.setCreatedAt(workerEntity.getCreatedAt());
		workerDTO.setUpdatedAt(workerEntity.getUpdatedAt());
		workerDTO.setName(workerEntity.getName());
		workerDTO.setIncomePerHour(workerEntity.getIncomePerHour());
		workerDTO.setBirthday(workerEntity.getBirthday());
		workerDTO.setWorkedHours(workerEntity.getWorkedHours());
		
		return workerDTO;
	}
	
	public WorkerEntity mergeDTOIntoEntity(WorkerEntity workerEntity, WorkerDTO workerDTO) {
		workerEntity.setName(workerDTO.getName());
		workerEntity.setIncomePerHour(workerDTO.getIncomePerHour());
		workerEntity.setBirthday(workerDTO.getBirthday());
		workerEntity.setWorkedHours(workerDTO.getWorkedHours());
		
		return workerEntity;
	}
	
	public WorkerEntity toEntity(WorkerDTO workerDTO) {
		WorkerEntity workerEntity = new WorkerEntity();
		workerEntity.setId(workerDTO.getId());
		workerEntity.setName(workerDTO.getName());
		workerEntity.setIncomePerHour(workerDTO.getIncomePerHour());
		workerEntity.setBirthday(workerDTO.getBirthday());
		workerEntity.setWorkedHours(workerDTO.getWorkedHours());
		
		return workerEntity;
	}
}
