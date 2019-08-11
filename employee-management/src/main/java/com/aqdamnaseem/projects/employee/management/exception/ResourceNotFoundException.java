package com.aqdamnaseem.projects.employee.management.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1604762315715630411L;

	/**
	 * @param message
	 * @param cause
	 */
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}

}
