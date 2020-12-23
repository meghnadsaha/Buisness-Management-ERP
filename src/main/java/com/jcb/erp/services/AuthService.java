package com.jcb.erp.services;

import org.springframework.http.ResponseEntity;

import com.jcb.erp.dto.requests.ClientCreateRequest;
import com.jcb.erp.dto.response.VechileManagementResponse;


public interface AuthService {
	ResponseEntity<VechileManagementResponse> registerClient(ClientCreateRequest clientCreateDto) throws Exception;

//	ResponseEntity<VechileManagementResponse> signin(SigninRequest clientLoginDto) throws Exception;
}
