package com.jcb.erp.exhandling.exceptions;

import java.util.Set;

import com.jcb.erp.utils.JcbErrors;

import lombok.Getter;

@Getter
public class ForbiddenParamsException extends RuntimeException {

    private Set<String> extraFields;
    private JcbErrors errors;

    public ForbiddenParamsException(Set<String> extraFields, JcbErrors errors){
        this.extraFields=extraFields;
        this.errors=errors;
    }
}
