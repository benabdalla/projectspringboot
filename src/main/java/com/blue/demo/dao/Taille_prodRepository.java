package com.blue.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.blue.demo.entities.Taille_prod;



@Transactional
public interface Taille_prodRepository extends JpaRepository<Taille_prod, Long>{

	


 	@Modifying
	@Query("Update Taille_prod c set quantite=quantite- :qte where c.taille.id_taille= :id_taille and c.article.id_article= :id_article")
	int updateSize(@Param("id_article") Long id_article,@Param("id_taille") Long id_taille, @Param("qte") int qte);
	
	
}
