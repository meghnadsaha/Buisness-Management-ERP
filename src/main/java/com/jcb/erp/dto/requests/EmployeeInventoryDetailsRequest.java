package com.jcb.erp.dto.requests;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeInventoryDetailsRequest {


	private String driver_no;
	
	private String salary;
	
	private  Date date_of_joining ;

	private Date date_of_salary_initiation;
	
	private String food_expenses;
	
	private String yearly_bonus; 
	
}
