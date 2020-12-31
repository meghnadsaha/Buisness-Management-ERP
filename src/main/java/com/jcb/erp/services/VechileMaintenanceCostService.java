package com.jcb.erp.services;

import org.springframework.http.ResponseEntity;

import com.jcb.erp.dto.requests.VechileMaintenanceCostRequest;
import com.jcb.erp.dto.response.VechileManagementResponse;

public interface VechileMaintenanceCostService {

	ResponseEntity<VechileManagementResponse> saveVechileMaintenanceCostDetail(VechileMaintenanceCostRequest vechileMaintenanceCostRequest) throws Exception;

}
