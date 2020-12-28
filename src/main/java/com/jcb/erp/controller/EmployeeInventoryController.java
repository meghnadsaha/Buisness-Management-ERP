package com.jcb.erp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcb.erp.dto.requests.ClientCreateRequest;
import com.jcb.erp.dto.requests.EmployeeInventoryDetailsRequest;
import com.jcb.erp.dto.response.VechileManagementResponse;
import com.jcb.erp.services.AuthService;
import com.jcb.erp.services.EmployeeInventoryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200" ,allowedHeaders = "*",allowCredentials = "true")
@RequestMapping("/erp_api/inventoryDetails")
public class EmployeeInventoryController {
	
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeInventoryController.class);

	@Autowired
	private EmployeeInventoryService employeeInventoryService;

	
	@PostMapping("/save")
	public ResponseEntity<VechileManagementResponse> saveEmployeeInventoryDetails(
			@RequestBody EmployeeInventoryDetailsRequest eInventoryDetails) throws Exception {
		
		
		log.info("saveEmployeeInventoryDetails() is called for driver no : {}", eInventoryDetails.getDriver_no());

		return employeeInventoryService.saveEmployeeInventoryDetails(eInventoryDetails);
	}
	
	

}
