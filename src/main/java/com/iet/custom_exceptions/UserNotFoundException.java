package com.iet.custom_exceptions;

public class UserNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String errMessage) {
		super(errMessage);
	}
}
