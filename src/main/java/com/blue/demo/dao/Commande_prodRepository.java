package com.blue.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blue.demo.entities.Commande_prod;

public interface Commande_prodRepository extends JpaRepository<Commande_prod, Long>{
	
	
	@Query("SELECT c.article.categorie.categorie_lib,sum(quantite) FROM Commande_prod c group by c.article.categorie.categorie_lib ") 
	 public  List stat_categorie( );
}
