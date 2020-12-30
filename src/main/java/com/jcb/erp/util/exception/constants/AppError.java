package com.jcb.erp.util.exception.constants;

public interface AppError extends OnlineError {
	public static final ExceptionStatus exceptionStatus = ExceptionStatus.KNOWN;

	public static final String errorMessage = "This is an application error message";

	public static final String errorTrace = "";
}
