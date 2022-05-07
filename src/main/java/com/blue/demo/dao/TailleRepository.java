package com.blue.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blue.demo.entities.Commande;
import com.blue.demo.entities.Taille;


public interface TailleRepository extends JpaRepository<Taille, Long> {


	 @Query("SELECT t.id_taille FROM Taille t where t.lib_taille= :t") 
	 public Long findBylib_taille(@Param("t") String t);
	


}
