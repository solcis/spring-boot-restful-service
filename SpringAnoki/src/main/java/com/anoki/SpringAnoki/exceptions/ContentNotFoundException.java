package com.anoki.SpringAnoki.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "content not found")
public class ContentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ContentNotFoundException() {
		super();
	}

	public ContentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	

}
