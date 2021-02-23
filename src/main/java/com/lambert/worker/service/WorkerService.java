package com.lambert.worker.service;

import org.springframework.data.domain.Page;

import com.lambert.worker.dto.WorkerDTO;

public interface WorkerService {
	Page<WorkerDTO> findAll(Integer page, Integer size);
	WorkerDTO findOne(Long id);
	void save(WorkerDTO workerDTO);
}
