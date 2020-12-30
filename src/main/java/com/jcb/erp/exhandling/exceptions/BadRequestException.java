package com.jcb.erp.exhandling.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BadRequestException extends RuntimeException {
	private String code;

	public BadRequestException(String code, String message) {
		super(message);
		this.code = code;
	}
}
