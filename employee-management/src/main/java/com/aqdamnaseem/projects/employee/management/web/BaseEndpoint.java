package com.aqdamnaseem.projects.employee.management.web;

import java.net.BindException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.aqdamnaseem.projects.employee.management.exception.ErrorResponse;
import com.aqdamnaseem.projects.employee.management.exception.ResourceAlreadyExistException;
import com.aqdamnaseem.projects.employee.management.exception.ResourceNotFoundException;

public abstract class BaseEndpoint {

	/**
	 * @param ex
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> handleException(Exception ex, WebRequest request) throws Exception {
		ResponseEntity<ErrorResponse> errorResponse = null;
		HttpStatus status = null;
		HttpHeaders headers = new HttpHeaders();
		if (ex instanceof ResourceNotFoundException) {
			status = HttpStatus.NOT_FOUND;
			errorResponse = handleResourceNotFound((ResourceNotFoundException) ex, headers, status, request);
		} else if (ex instanceof ResourceAlreadyExistException) {
			status = HttpStatus.CONFLICT;
			errorResponse = handleResourceAlreadyExist((ResourceAlreadyExistException) ex, headers, status, request);
		} else if (ex instanceof BindException) {
			status = HttpStatus.BAD_REQUEST;
			errorResponse = handleBindingException((BindException) ex, headers, status, request);
		} else {
			throw ex;
		}
		return errorResponse;

	}

	/**
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return
	 */
	private ResponseEntity<ErrorResponse> handleBindingException(BindException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return
	 */
	private ResponseEntity<ErrorResponse> handleResourceAlreadyExist(ResourceAlreadyExistException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return
	 */
	private ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
