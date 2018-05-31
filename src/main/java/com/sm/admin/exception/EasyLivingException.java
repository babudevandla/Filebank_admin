package com.sm.admin.exception;

public class EasyLivingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EasyLivingException() {
	}

	public EasyLivingException(Throwable throwable) {
		super(throwable);
	}

	public EasyLivingException(String message) {
		super(message);
	}

	public EasyLivingException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
