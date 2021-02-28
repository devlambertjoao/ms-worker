package com.lambert.worker.service.impl;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lambert.worker.data.mssql.entity.WorkerEntity;
import com.lambert.worker.data.mssql.repository.WorkerRepository;
import com.lambert.worker.dto.WorkerDTO;
import com.lambert.worker.exception.ResourceNotFoundException;
import com.lambert.worker.mapper.WorkerMapper;
import com.lambert.worker.service.WorkerService;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerRepository workerRepository;

	@Autowired
	private WorkerMapper workerMapper;

	@Override
	public Page<WorkerDTO> findAll(Integer page, Integer size) {
		return workerRepository.findAll(PageRequest.of(page, size)).map(workerMapper::toDTO);
	}

	@Override
	public WorkerDTO findOne(Long id) throws ResourceNotFoundException {
		return workerMapper.toDTO(
				workerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Worker not found")));
	}

	@Transient
	@Override
	public void save(WorkerDTO workerDTO) throws ResourceNotFoundException {
		WorkerEntity workerEntity = new WorkerEntity();
		
		if(workerDTO.getId() != null) {
			workerEntity = workerRepository.findById(workerDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Worker not found"));
		}
		workerMapper.toEntity(workerEntity, workerDTO);
		workerRepository.save(workerEntity);
	}

}
