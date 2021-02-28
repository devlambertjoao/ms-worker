package com.lambert.payroll.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseException {
	private static final long serialVersionUID = 1L;
	
	@Override
	public HttpStatus getHttpStatus() {
		return HttpStatus.NOT_FOUND;
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(List<String> messages) {
		super(messages);
	}
	
}
