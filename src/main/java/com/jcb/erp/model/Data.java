package com.jcb.erp.model;

import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	private Integer request_id;
	private String created_at;
	private Integer consent_id;
	private String expired_at;
	private Integer max_usages;
	private Integer used_count;
	private String score;
	private String verify;
	private String access_token;
	private Set<String> forbidden_parameters;
	private List<String> missing_parameters;
	private List<String> field_errors;

}
