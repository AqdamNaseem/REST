package com.aqdamnaseem.projects.employee.management.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = -1719003250746007239L;

	private HttpStatus status;
	private String errorCode;
	private String message;
	private String detail;

	public static class Builder {

		private HttpStatus status;
		private String errorCode;
		private String message;
		private String detail;

		public Builder status(HttpStatus status) {
			this.status = status;
			return this;
		}

		public Builder errorCode(String errorCode) {
			this.errorCode = errorCode;
			return this;
		}

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public Builder detail(String detail) {
			this.detail = detail;
			return this;
		}

		public ErrorResponse build() {
			return new ErrorResponse(this);
		}
	}

	private ErrorResponse(Builder builder) {
		status = builder.status;
		errorCode = builder.errorCode;
		message = builder.message;
		detail = builder.detail;
	}
}
