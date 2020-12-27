package com.jcb.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DynamicUpdate
@Table(name = "VECHILE_MAINTENANCE_COST")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VechileMaintenanceCost extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "PRODUCT_ID")
	private String product_id;

	@Column(name = "PRODUCT_NAME")
	private String product_name;

	@Column(name = "PRODUCT_COST")
	private String product_cost;

	@Column(name = "DURABILITY")
	private String durability;

	@Column(name = "MAINTAINCE_VENUE")
	private String maintaince_venue;

	@Column(name = "JCB_MECHANICS_CONTACT_DETAILS")
	private String jcb_mechanics_contact_details;

}
