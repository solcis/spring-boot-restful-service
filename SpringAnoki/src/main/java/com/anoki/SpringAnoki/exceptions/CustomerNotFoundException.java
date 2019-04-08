package com.anoki.SpringAnoki.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "customer not found")
public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
		super();
	}

	public CustomerNotFoundException(String message, Throwable error) {
		super(message, error);
	}

}
