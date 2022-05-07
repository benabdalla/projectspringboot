package com.blue.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blue.demo.entities.Compte;
import com.blue.demo.entities.User;

public interface CompteRepository extends JpaRepository<Compte, Long> {

	
	
	@Query("SELECT u FROM Compte u where login= :login and  password= :password ") 
	 public Compte  findUser(@Param("login") String login,@Param("password") String password);

	@Query("SELECT u FROM Compte u where login= :login") 
	public Compte findLogin(@Param("login") String login);

 	
	Boolean existsByLogin(String email);

	 
}
