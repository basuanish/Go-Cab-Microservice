package com.capgemini.GoCab.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookingException extends RuntimeException {
	
	private static final long serialVersionUID = -4005267182579342970L;

	public BookingException() {

	}

	public BookingException(String message) {
		super(message);

	}

	public BookingException(Throwable cause) {
		super(cause);

	}

	public BookingException(String message, Throwable cause) {
		super(message, cause);

	}

	public BookingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
