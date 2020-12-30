package com.jcb.erp.exhandling.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.jcb.erp.dto.response.VechileManagementResponse;

import lombok.Getter;

@Getter
public class ServerErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Autowired
	private VechileManagementResponse vechileManagementResponse;

	HttpStatus status;

	public ServerErrorException(String message, HttpStatus status,
			VechileManagementResponse vechileManagementResponse) {
		super(message);
		this.vechileManagementResponse = vechileManagementResponse;
		this.status = status;
	}

}
