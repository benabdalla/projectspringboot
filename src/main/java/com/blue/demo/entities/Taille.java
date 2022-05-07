package com.blue.demo.entities;

import java.util.HashSet;
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
public class Taille {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_taille;
	
	private String lib_taille;
	
	@ManyToOne 
	@JoinColumn (name="id_categorie")
	private Categorie categorie;
	 
	  @OneToMany(mappedBy = "taille")
	    Set<Taille_prod> taille_prod=new HashSet<>();

	 

	public Taille(Long id_taille, String lib_taille, Categorie categorie) {
		super();
		this.id_taille = id_taille;
		this.lib_taille = lib_taille;
		this.categorie = categorie;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Taille() {
		super();
	}

	public Long getId_taille() {
		return id_taille;
	}

	public void setId_taille(Long id_taille) {
		this.id_taille = id_taille;
	}

	public String getLib_taille() {
		return lib_taille;
	}

	public void setLib_taille(String lib_taille) {
		this.lib_taille = lib_taille;
	}



	public void setTaille_prod(Set<Taille_prod> taille_prod) {
		this.taille_prod = taille_prod;
	}
	 
}
