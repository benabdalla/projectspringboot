package com.blue.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blue.demo.entities.State;

public interface StateRepository extends JpaRepository<State, Long>{

}