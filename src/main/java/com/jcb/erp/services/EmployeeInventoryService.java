package com.jcb.erp.services;

import org.springframework.http.ResponseEntity;

import com.jcb.erp.dto.requests.EmployeeInventoryDetailsRequest;
import com.jcb.erp.dto.response.VechileManagementResponse;

public interface EmployeeInventoryService {

	ResponseEntity<VechileManagementResponse> saveEmployeeInventoryDetails(
			EmployeeInventoryDetailsRequest employeeInventoryDetailsRequest) throws Exception;

}
