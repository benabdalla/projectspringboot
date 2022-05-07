package com.blue.demo.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_privilege;
	
	private String lib_privilege;
	
	
	@OneToMany(mappedBy="privilege")
	private Set<User> User;


	public Long getId_privilege() {
		return id_privilege;
	}


	public void setId_privilege(Long id_privilege) {
		this.id_privilege = id_privilege;
	}


	public String getLib_privilege() {
		return lib_privilege;
	}


	public void setLib_privilege(String lib_privilege) {
		this.lib_privilege = lib_privilege;
	}




	public void setUser(Set<User> user) {
		User = user;
	}


	public Privilege(Long id_privilege, String lib_privilege, Set<com.blue.demo.entities.User> user) {
		super();
		this.id_privilege = id_privilege;
		this.lib_privilege = lib_privilege;
		User = user;
	}


	public Privilege() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
