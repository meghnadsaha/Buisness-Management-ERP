package com.jcb.erp.exhandling.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jcb.erp.model.Data;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class InternalErrorResponse {
    private String verdict;
    private String message;
    private String time;
    private Data data;
    private Boolean success;
    private Integer errorCode;
}
