package com.jcb.erp.utils;


import org.springframework.http.HttpStatus;

import com.jcb.erp.util.exception.constants.AppError;
import com.jcb.erp.util.exception.constants.ExceptionStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum JcbErrors implements AppError {
	
	INVAILD_ID_NUMBER("invalid_parameters", "id number is invalid", 1000, HttpStatus.BAD_REQUEST),
	MALFORMED_JSON("malformed_json", "request body is not a valid JSON", 1001, HttpStatus.BAD_REQUEST),
	DB_CONNECTION_ISSUE("connection_issue", "Something went wrong. Please try again.", 1002,HttpStatus.INTERNAL_SERVER_ERROR),
	INVALID_PARAMS("invalid_parameters", "some of the parameters are invalid", 1003, HttpStatus.BAD_REQUEST), 
	INVALID_CREDENTIALS("invalid_credentials", "username or password is incorrect", 1004, HttpStatus.UNAUTHORIZED), 
	MISSING_PARAMS("missing_parameters", "some required parameters are missing", 1005, HttpStatus.BAD_REQUEST);
	
	String code;
	String message;
	int errorCode;
	HttpStatus statusCode;
	@Override
	public ExceptionStatus geExceptionStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getErrorCode() {
		return Integer.toString(errorCode);
	}
	@Override
	public String getErrorTrace() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUserMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}