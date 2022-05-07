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
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_categorie;
	private String  categorie_lib;
	
	
	@OneToMany(mappedBy="categorie")
	private Set<Article> Articles;

	@OneToMany(mappedBy="categorie")
	private Set<Taille> Taille;


	@ManyToMany
	Set<Gender> gender;


	public Categorie(String categorie_lib, Set<Gender> gender) {
		super();
		this.categorie_lib = categorie_lib;
		this.gender = gender;
	}


	public Set<Gender> getGender() {
		return gender;
	}


	public void setGender(Set<Gender> gender) {
		this.gender = gender;
	}


	public Categorie(String categorie_lib, Set<Article> articles, Set<com.blue.demo.entities.Taille> taille,
			Set<Gender> gender) {
		super();
		this.categorie_lib = categorie_lib;
		Articles = articles;
		Taille = taille;
		this.gender = gender;
	}


	public Categorie() {
		super();
	}


	public Long getId_categorie() {
		return id_categorie;
	}


	public void setId_categorie(Long id_categorie) {
		this.id_categorie = id_categorie;
	}


	public String getCategorie_lib() {
		return categorie_lib;
	}


	public void setCategorie_lib(String categorie_lib) {
		this.categorie_lib = categorie_lib;
	}


	 

 
  



	
	
}
