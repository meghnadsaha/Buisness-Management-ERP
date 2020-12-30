package com.jcb.erp.util.exception.constants;

public interface OnlineError {
	  ExceptionStatus geExceptionStatus();
	  
	  String getErrorCode();
	  
	  String getUserMessage();
	  
	  String getErrorTrace();
	}
