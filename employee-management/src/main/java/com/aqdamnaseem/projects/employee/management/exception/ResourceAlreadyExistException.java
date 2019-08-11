package com.aqdamnaseem.projects.employee.management.exception;

public class ResourceAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 7631231727682085089L;

	/**
	 * @param message
	 * @param cause
	 */
	public ResourceAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ResourceAlreadyExistException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ResourceAlreadyExistException(Throwable cause) {
		super(cause);
	}

}
