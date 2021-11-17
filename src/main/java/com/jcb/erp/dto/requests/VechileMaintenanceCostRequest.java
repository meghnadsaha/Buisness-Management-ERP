package com.jcb.erp.dto.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VechileMaintenanceCostRequest {

	@NotBlank(message = "Product id cannot be empty")
	@Size(min = 3, max = 50, message = "Product id size must be between 3 and 50")
	private String product_id;

	@NotBlank(message = "Product Name cannot be empty")
	@Size(min = 3, max = 50, message = "Product Name  size must be between 3 and 50")
	private String product_name;

	@NotBlank(message = "Product Cost cannot be empty")
	@Size(min = 3, max = 50, message = "Product Cost size must be between 3 and 50")
	private String product_cost;

	@NotBlank(message = "Durability cannot be empty")
	@Size(min = 3, max = 50, message = "Durability size must be between 3 and 50")
	private String durability;

	@NotBlank(message = "Maintaince venue cannot be empty")
	@Size(min = 3, max = 50, message = "Maintaince venue size must be between 3 and 50")
	private String maintaince_venue;

	@NotBlank(message = "Mechanics Contact Details cannot be empty")
	@Size(min = 10, max = 13, message = "Mechanics Contact Details size must be between 10 and 13")
	private String jcb_mechanics_contact_details;
}
