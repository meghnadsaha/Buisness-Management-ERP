package com.jcb.erp.exhandling.exceptions;

import com.jcb.erp.utils.JcbErrors;

import lombok.Data;

import java.util.List;

@Data
public class MissingParamException extends RuntimeException {

	private JcbErrors jcbErrors;
	private List<String> missingParams;

	public MissingParamException(List<String> missingParams, JcbErrors jcbErrors) {
		this.missingParams = missingParams;
		this.jcbErrors = jcbErrors;
	}
}
