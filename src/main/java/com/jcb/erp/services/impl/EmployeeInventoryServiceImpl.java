package com.jcb.erp.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jcb.erp.dto.requests.EmployeeInventoryDetailsRequest;
import com.jcb.erp.dto.response.VechileManagementResponse;
import com.jcb.erp.model.EmployeeInventoryDetails;
import com.jcb.erp.repository.EmployeeInventoryRepository;
import com.jcb.erp.services.EmployeeInventoryService;
import com.jcb.erp.utils.DateUtility;

@Service
public class EmployeeInventoryServiceImpl implements EmployeeInventoryService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeInventoryServiceImpl.class);

	@Autowired
	EmployeeInventoryRepository employeeInventoryRepository;
	
	@Override
	public ResponseEntity<VechileManagementResponse> saveEmployeeInventoryDetails(
			EmployeeInventoryDetailsRequest employeeInventoryDetailsRequest) throws Exception {

		EmployeeInventoryDetails eInventoryDetails = EmployeeInventoryDetails
				.builder()
				.driver_no(employeeInventoryDetailsRequest.getDriver_no())
				.salary(employeeInventoryDetailsRequest.getSalary())
				.date_of_joining(employeeInventoryDetailsRequest.getDate_of_joining())
				.date_of_salary_initiation(employeeInventoryDetailsRequest.getDate_of_salary_initiation())
				.food_expenses(employeeInventoryDetailsRequest.getFood_expenses())
				.yearly_bonus(employeeInventoryDetailsRequest.getYearly_bonus())
				.build();

		log.info("saveEmployeeInventoryDetails() is called for driver no : {} ", eInventoryDetails.getDriver_no());

		employeeInventoryRepository.save(eInventoryDetails);

		VechileManagementResponse response = VechileManagementResponse.builder()
				.success(true)
				.verdict("success")
				.message("Inventory Created Successfully for driver no : "+ eInventoryDetails.getDriver_no())
				.time(DateUtility.getCurrentDateInYYYYMMDDHHMMSSZ())
				.build();
		return new ResponseEntity<VechileManagementResponse>(response, HttpStatus.OK);
	}

}
