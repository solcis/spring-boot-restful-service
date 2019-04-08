package com.anoki.SpringAnoki.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "shopping cart not found")
public class ShoppingCartNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ShoppingCartNotFoundException() {
	}

	public ShoppingCartNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
