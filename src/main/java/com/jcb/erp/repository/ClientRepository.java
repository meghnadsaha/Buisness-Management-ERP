package com.jcb.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcb.erp.model.Users;

@Repository
public interface ClientRepository extends JpaRepository<Users, Long> {
}