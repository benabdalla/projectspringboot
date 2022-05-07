package com.blue.demo.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Modelivraison {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_modeliv;
	
	private String lib_mod_liv;
	
	
	 
	public Long getId_modeliv() {
		return id_modeliv;
	}

	public void setId_modeliv(Long id_modeliv) {
		this.id_modeliv = id_modeliv;
	}

	public String getLib_mod_liv() {
		return lib_mod_liv;
	}

	public void setLib_mod_liv(String lib_mod_liv) {
		this.lib_mod_liv = lib_mod_liv;
	}
 

	public Modelivraison(String lib_mod_liv, Set<com.blue.demo.entities.Livraison> livraison) {
		super();
		this.lib_mod_liv = lib_mod_liv;
 	}

	public Modelivraison() {
		super();
	}
	
	

	
}
