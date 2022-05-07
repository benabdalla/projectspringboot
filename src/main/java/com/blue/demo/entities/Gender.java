package com.blue.demo.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Gender {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_gender;
	private String  gender_lib;
	
	
	@OneToMany(mappedBy="gender")
	private Set<Article> Articles;
	
	 

	@ManyToMany
	Set<Categorie> categorie;
	
	
	
	public Gender(String gender_lib, Set<Categorie> categorie) {
		super();
		this.gender_lib = gender_lib;
		this.categorie = categorie;
	}

	public Gender() {
		super();
	}

	public Long getId_gender() {
		return id_gender;
	}

	public void setId_gender(Long id_gender) {
		this.id_gender = id_gender;
	}

	public String getGender_lib() {
		return gender_lib;
	}

	public void setGender_lib(String gender_lib) {
		this.gender_lib = gender_lib;
	}

	public Set<Categorie> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categorie> categorie) {
		this.categorie = categorie;
	}

 


 
	
}
