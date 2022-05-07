package com.blue.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.blue.demo.entities.Favoris;

@Transactional
public interface FavorisRepository extends JpaRepository<Favoris, Long>{
 
	@Query("SELECT f FROM Favoris f  where id_user= :id") 
	public <list>Favoris articlefavorie(@Param("id") Long id);
	
	@Query("SELECT f from Favoris f where f.user.id_user=:user and f.article.id_article=:article") 
	public Optional<Favoris> IfInFavorisListe(@Param("user") Long user, @Param("article") Long article);

	
	@Modifying
	@Query("delete from Favoris f where f.user.id_user=:user and f.article.id_article=:article")
	void deleteFavoris(@Param("user") Long user, @Param("article") Long article);
	
}
