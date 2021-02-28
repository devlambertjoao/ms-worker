package com.lambert.payroll.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends Exception {
	private static final long serialVersionUID = 1L;
	private final List<String> messages;

	public HttpStatus getHttpStatus() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	public List<String> getMessages() {
		return this.messages;
	}

	protected BaseException(String message) {
		this.messages = new ArrayList<>();
		this.messages.add(message);
	}
	
	protected BaseException(List<String> messages) {
		this.messages = messages;
	}
}
