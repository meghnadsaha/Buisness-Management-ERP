package com.jcb.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcb.erp.model.Users;
import com.jcb.erp.model.VechileMaintenanceCost;

@Repository
public interface VechileMaintenanceCostRepository extends JpaRepository<VechileMaintenanceCost, Long> {
}