package com.jcb.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcb.erp.model.EmployeeInventoryDetails;

@Repository
public interface EmployeeInventoryRepository extends JpaRepository<EmployeeInventoryDetails, Long> {

}
