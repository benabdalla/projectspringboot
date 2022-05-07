package com.blue.demo.dao;

 
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blue.demo.entities.Article;
import com.blue.demo.entities.User;



public interface ArticleRepository extends JpaRepository<Article, Long>{
	/*
	 * 
	Page<Article> findAll(int i, int j);
 	 @Query("SELECT u FROM article u limit :from ") 
	 public  List<Article> findSixArticles(@Param("from") int from);
	 */
	 @Query("SELECT count(c) FROM Article c  ") 
	 public  int  articles();
	 
	 @Query("SELECT p FROM Article p where  p.designation like :des  or p.description_article like :des ") 
	 public List<Article> findbydesignation(@Param("des") String des);
}
