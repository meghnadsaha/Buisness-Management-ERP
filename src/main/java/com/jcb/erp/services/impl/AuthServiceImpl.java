package com.jcb.erp.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jcb.erp.controller.AuthController;
import com.jcb.erp.dto.requests.ClientCreateRequest;
import com.jcb.erp.dto.response.VechileManagementResponse;
import com.jcb.erp.model.Users;
import com.jcb.erp.services.AuthService;

import com.jcb.erp.repository.ClientRepository;
import com.jcb.erp.utils.DateUtility;


@Service
public class AuthServiceImpl implements AuthService {

	private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Bean
	PasswordEncoder passwordEncoder() 
	{
	    return new BCryptPasswordEncoder();
	}
	
	
	@Override
	public ResponseEntity<VechileManagementResponse> registerClient(ClientCreateRequest clientDto)
			throws Exception {
		// TODO Auto-generated method stub
		Users client = Users.builder().username(clientDto.getUsername())
				.password(passwordEncoder.encode(clientDto.getPassword())).build();

		log.info("registerClient() is called for user name : {}",clientDto.getUsername());
		
		clientRepository.save(client);

		VechileManagementResponse response = VechileManagementResponse.builder()
				.success(true)
				.verdict("success")
				.message("User Created Successfully with username:" + clientDto.getUsername())
				.time(DateUtility.getCurrentDateInYYYYMMDDHHMMSSZ()).build();
		return new ResponseEntity<VechileManagementResponse>(response, HttpStatus.OK);	}
	
}
