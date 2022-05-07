package com.blue.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.blue.demo.entities.User;
 
@Transactional

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u where id_compte= :id") 
	public <list>User UserToCompte(@Param("id") Long id);
 
	 @Query("SELECT c FROM User c where id_privilege =3 or id_privilege =1 ") 
	 public  List<User> staff();
	  
	 @Query("SELECT count(c) FROM User c  ") 
	 public  int  users();
}
