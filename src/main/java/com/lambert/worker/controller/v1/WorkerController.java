package com.lambert.worker.controller.v1;

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
import com.lambert.worker.service.WorkerService;

@RestController
@RequestMapping("/v1/worker")
public class WorkerController {
	
	@Autowired
	private WorkerService workerService;
	
	@GetMapping
	public ResponseEntity<Object> findAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
		try {
			return new ResponseEntity<>(workerService.findAll(page, size), HttpStatus.OK);
		} 
		catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="{id}")
	public ResponseEntity<Object> findOne(@PathVariable(value="id") Long id) {
		try {
			return new ResponseEntity<>(workerService.findOne(id), HttpStatus.OK);
		} 
		catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@RequestBody WorkerDTO workerDTO) {
		try {
			workerService.save(workerDTO);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
