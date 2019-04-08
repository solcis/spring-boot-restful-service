package com.anoki.SpringAnoki.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "not enough founds to complete the operation")
public class NotEnoughFoundsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotEnoughFoundsException() {
		super();
	}

	public NotEnoughFoundsException(String message, Throwable cause) {
		super(message, cause);
	}

}
