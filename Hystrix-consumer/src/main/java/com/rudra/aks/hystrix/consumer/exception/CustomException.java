package com.rudra.aks.hystrix.consumer.exception;

public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomException(String message) {
		super(message);
	}
	
	

}
