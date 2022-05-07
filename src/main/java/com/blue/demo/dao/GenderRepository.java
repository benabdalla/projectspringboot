package com.blue.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blue.demo.entities.Categorie;
import com.blue.demo.entities.Commande;
import com.blue.demo.entities.Gender;


public interface GenderRepository extends JpaRepository<Gender, Long>{

	/* @Query("SELECT c FROM gender c where c.categorie='1'") 
	 public  List<Categorie> Liste_categorie(@Param("gender") String gender);
	*/
}
