package com.blue.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blue.demo.entities.Commande;
import com.blue.demo.entities.Livraison;

public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
	@Query("SELECT c FROM Livraison c where id_user= :id    ") 
	 public  List<Livraison> historique(@Param("id") Long id);
}
