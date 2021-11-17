package com.jcb.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcb.erp.model.VechileMaintenanceCost;


// -Spring @Repository annotation is used to indicate that the class provides the
//mechanism for storage, retrieval, search, update and delete operation on objects.
@Repository
public interface VechileMaintenanceCostRepository extends JpaRepository<VechileMaintenanceCost, Long> {

	List<VechileMaintenanceCost> findByAvailability(boolean availability);

//	List<VechileMaintenanceCost> findByproduct_nameContaining(String title);
//	save(), findOne(), findById(), findAll(), count(), delete(), deleteById()

}
