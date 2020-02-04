package com.capgemini.GoCab.exception;

public class UserNotSavedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotSavedException() {
		super();
	}

	public UserNotSavedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotSavedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotSavedException(String message) {
		super(message);
	}

	public UserNotSavedException(Throwable cause) {
		super(cause);
	}

}
