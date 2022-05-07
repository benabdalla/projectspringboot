package com.blue.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_adresse;
	private String lib_adresse;
	
	@ManyToOne 
	@JoinColumn (name="id_city")
	private City City;
	
	


	public Long getId_adresse() {
		return id_adresse;
	}

	
	
	public void setId_adresse(Long id_adresse) {
		this.id_adresse = id_adresse;
	}

	public String getLib_adresse() {
		return lib_adresse;
	}

	public void setLib_adresse(String lib_adresse) {
		this.lib_adresse = lib_adresse;
	}

	

	
	

	public Adresse(String lib_adresse, com.blue.demo.entities.City city, Set<Boutique> boutique,
			Set<Commande> commande, Set<User> user) {
		super();
		this.lib_adresse = lib_adresse;
		City = city;

	}

	public City getCity() {
		return City;
	}

	public void setCity(City city) {
		City = city;
	}

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
