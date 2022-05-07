package com.blue.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blue.demo.entities.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

}
