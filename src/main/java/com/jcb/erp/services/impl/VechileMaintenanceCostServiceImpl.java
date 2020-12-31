package com.jcb.erp.services.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jcb.erp.dto.requests.VechileMaintenanceCostRequest;
import com.jcb.erp.dto.response.VechileManagementResponse;
import com.jcb.erp.model.Users;
import com.jcb.erp.model.VechileMaintenanceCost;
import com.jcb.erp.repository.ClientRepository;
import com.jcb.erp.repository.VechileMaintenanceCostRepository;
import com.jcb.erp.services.VechileMaintenanceCostService;
import com.jcb.erp.utils.DateUtility;

public class VechileMaintenanceCostServiceImpl implements VechileMaintenanceCostService {

	private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);

	@Autowired
	VechileMaintenanceCostRepository vechileMaintenanceCostRepository;

	@Override
	public ResponseEntity<VechileManagementResponse> saveVechileMaintenanceCostDetail(
			VechileMaintenanceCostRequest vechileMaintenanceCostRequest) throws Exception {
		// TODO Auto-generated method stub
		VechileMaintenanceCost vMaintenanceCostDto = VechileMaintenanceCost.builder()
				.product_id(vechileMaintenanceCostRequest.getProduct_id())
				.product_name(vechileMaintenanceCostRequest.getProduct_name())
				.product_cost(vechileMaintenanceCostRequest.getProduct_cost())
				.durability(vechileMaintenanceCostRequest.getDurability())
				.maintaince_venue(vechileMaintenanceCostRequest.getMaintaince_venue())
				.jcb_mechanics_contact_details(vechileMaintenanceCostRequest.getJcb_mechanics_contact_details())
				.build();

		log.info("saveVechileMaintenanceCostDetail() is called for product name : {}", vMaintenanceCostDto.getProduct_name());

		vechileMaintenanceCostRepository.save(vMaintenanceCostDto);

		VechileManagementResponse response = VechileManagementResponse.builder().success(true).verdict("success")
				.message(vMaintenanceCostDto.getProduct_name() + " Stored Successfully ." )
				.time(DateUtility.getCurrentDateInYYYYMMDDHHMMSSZ())
				.build();
		return new ResponseEntity<VechileManagementResponse>(response, HttpStatus.OK);
	}

}
