package com.blue.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blue.demo.entities.City;

public interface CityRepository extends JpaRepository<City, Long>{

}