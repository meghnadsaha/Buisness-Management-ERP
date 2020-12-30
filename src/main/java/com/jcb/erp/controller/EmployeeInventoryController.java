package com.jcb.erp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jcb.erp.dto.requests.ClientCreateRequest;
import com.jcb.erp.dto.requests.EmployeeInventoryDetailsRequest;
import com.jcb.erp.dto.response.VechileManagementResponse;
import com.jcb.erp.exhandling.exceptions.MissingParamException;
import com.jcb.erp.logger.JcbLogger;
import com.jcb.erp.logger.LoggerEventType;
import com.jcb.erp.services.AuthService;
import com.jcb.erp.services.EmployeeInventoryService;
import com.jcb.erp.utils.JcbErrors;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
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

	@GetMapping("/v2/save")
	// @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<VechileManagementResponse> getRechargeHistory(
			@RequestBody EmployeeInventoryDetailsRequest employeeInventoryDetailsRequest) throws Exception {

		missingParamsHandlerForsaveEmployeeFlow(employeeInventoryDetailsRequest,LoggerEventType.EMPLOYEE_INVENTORY_DETAILS_REQUEST);

		ResponseEntity<VechileManagementResponse> vechileManagementResponse = employeeInventoryService
				.saveEmployeeInventoryDetails(employeeInventoryDetailsRequest);

		return new ResponseEntity<VechileManagementResponse>(vechileManagementResponse.getBody(),
				vechileManagementResponse.getStatusCode());
	}

	private void missingParamsHandlerForsaveEmployeeFlow(
			EmployeeInventoryDetailsRequest employeeInventoryDetailsRequest, LoggerEventType type) throws Exception {
		List<String> missingParamList = new ArrayList<>();
		if (null == employeeInventoryDetailsRequest.getDriver_no())
			missingParamList.add("driver_no");
		if (null == employeeInventoryDetailsRequest.getSalary())
			missingParamList.add("salary");
		if (null == employeeInventoryDetailsRequest.getFood_expenses())
			missingParamList.add("food_expenses");
		if (!missingParamList.isEmpty()) {
			JcbLogger.log(true, true, LoggerEventType.MISSING_PARAMS, employeeInventoryDetailsRequest);
			throw new MissingParamException(missingParamList, JcbErrors.MISSING_PARAMS);
		}
	}
}
