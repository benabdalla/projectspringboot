package com.blue.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blue.demo.entities.Categorie;
import com.blue.demo.entities.Gender;

 

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

	
	/* @Query("SELECT count(*) FROM Categorie c JOIN c.gender g  where c.gender.id_gender='1' and g.categorie.id_categorie='1' ") 
	 public  List<Categorie> Liste_categorie(@Param("gender") String gender);
	*/
}
