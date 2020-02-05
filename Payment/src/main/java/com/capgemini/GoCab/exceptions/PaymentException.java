package com.capgemini.GoCab.exceptions;

public class PaymentException extends RuntimeException {
	
	private static final long serialVersionUID = -4005267182578342970L;

	public PaymentException() {

	}

	public PaymentException(String message) {
		super(message);

	}

	public PaymentException(Throwable cause) {
		super(cause);

	}

	public PaymentException(String message, Throwable cause) {
		super(message, cause);

	}

	public PaymentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
