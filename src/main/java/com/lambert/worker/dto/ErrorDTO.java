package com.lambert.worker.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ErrorDTO {
	private List<String> errors;
	
	public ErrorDTO(List<String> errors) {
		this.errors = errors;
	}
	
	public ErrorDTO(String error) {
		this.errors = new ArrayList<>();
		this.errors.add(error);
	}
	
	public ErrorDTO() {
		this.errors = new ArrayList<>();
	}
}
