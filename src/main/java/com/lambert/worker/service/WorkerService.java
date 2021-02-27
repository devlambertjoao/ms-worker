package com.lambert.worker.service;

import org.springframework.data.domain.Page;

import com.lambert.worker.dto.WorkerDTO;
import com.lambert.worker.exception.ResourceNotFoundException;

public interface WorkerService {
	Page<WorkerDTO> findAll(Integer page, Integer size);
	WorkerDTO findOne(Long id) throws ResourceNotFoundException;
	void save(WorkerDTO workerDTO) throws ResourceNotFoundException;
}
