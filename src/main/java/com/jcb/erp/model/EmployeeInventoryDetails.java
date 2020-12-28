package com.jcb.erp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@DynamicUpdate
@Table(name = "EMPLOYEE_INVENTORY_DETAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeInventoryDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long sr_number;
 
	@Column(name = "driver_no")
	private String driver_no;
	
	@Column(name = "salary")
	private String salary;
	
	@Column(name= "date_of_joining")
	private  Date date_of_joining ;

	@Column(name="date_of_salary_initiation")
	private Date date_of_salary_initiation;
	
	@Column(name="food_expenses")
	private String food_expenses;
	
	@Column(name= "yearly_bonus")
	private String yearly_bonus; 
	
	
}
