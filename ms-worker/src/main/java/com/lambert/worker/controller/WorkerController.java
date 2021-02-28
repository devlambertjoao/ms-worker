package com.lambert.worker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lambert.worker.dto.WorkerDTO;
import com.lambert.worker.exception.ResourceNotFoundException;
import com.lambert.worker.service.WorkerService;

@RestController
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	@GetMapping
	public ResponseEntity<Object> findAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
		return new ResponseEntity<>(workerService.findAll(page, size), HttpStatus.OK);
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Object> findOne(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		return new ResponseEntity<>(workerService.findOne(id), HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@RequestBody WorkerDTO workerDTO) throws ResourceNotFoundException {
		workerService.save(workerDTO);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
