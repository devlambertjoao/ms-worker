package com.lambert.payroll.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lambert.payroll.dto.ErrorDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception exception) {
		return new ResponseEntity<>(new ErrorDTO(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception) {
		return new ResponseEntity<>(new ErrorDTO(exception.getMessages()), exception.getHttpStatus());
	}
}
