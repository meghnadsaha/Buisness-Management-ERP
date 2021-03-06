package com.jcb.erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcb.erp.services.AuthService;
import com.jcb.erp.dto.requests.ClientCreateRequest;
import com.jcb.erp.dto.response.VechileManagementResponse;


@RestController
@RequestMapping("/score_api/auth")
public class AuthController {

	private static final Logger log = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private AuthService authService;

	// @ApiOperation(value = "Register Client", response =
	// CreditInsightResponse.class)
	@PostMapping("/signup")
	public ResponseEntity<VechileManagementResponse> registerClient(
			@RequestBody ClientCreateRequest clientCreateRequest) throws Exception {
		log.info("registerClient() is called for userid : {}", clientCreateRequest.getUsername());

		return authService.registerClient(clientCreateRequest);
	}
}
