package com.lambert.worker.service.impl;

import java.util.Optional;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lambert.worker.data.mssql.entity.WorkerEntity;
import com.lambert.worker.data.mssql.repository.WorkerRepository;
import com.lambert.worker.dto.WorkerDTO;
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
	public WorkerDTO findOne(Long id) {
		return workerMapper.toDTO(workerRepository.getOne(id));
	}

	@Transient
	@Override
	public void save(WorkerDTO workerDTO) {
		Optional<WorkerEntity> existentWorkerEntity = workerRepository.findById(workerDTO.getId());
		if(existentWorkerEntity.isPresent()) {
			workerRepository.save(workerMapper.mergeDTOIntoEntity(existentWorkerEntity.get(), workerDTO));
		} else {
			workerRepository.save(workerMapper.toEntity(workerDTO));
		}
	}

}
