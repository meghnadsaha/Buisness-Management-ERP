package com.jcb.erp.exhandling.exceptions;

import com.jcb.erp.utils.JcbErrors;

import lombok.Getter;

@Getter
public class JcbException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private JcbErrors error = null;
	
	public JcbException(JcbErrors error) {
        super(error.toString());
        this.error = error;
    }
}
