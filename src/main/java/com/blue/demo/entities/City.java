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
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_city;
	private String lib_city;
	private String zip_code;

	@ManyToOne 
	@JoinColumn (name="id_state")
	private State state;
	
	
	
	@OneToMany(mappedBy = "City")
    Set<Adresse> Adresse=new HashSet<>();
	
	
	
	public Long getId_city() {
		return id_city;
	}

	public void setId_city(Long id_city) {
		this.id_city = id_city;
	}

	public String getLib_city() {
		return lib_city;
	}

	public void setLib_city(String lib_city) {
		this.lib_city = lib_city;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	


	public City(String lib_city, String zip_code, State state, Set<com.blue.demo.entities.Adresse> adresse) {
		super();
		this.lib_city = lib_city;
		this.zip_code = zip_code;
		this.state = state;
		Adresse = adresse;
	}



	public void setAdresse(Set<Adresse> adresse) {
		Adresse = adresse;
	}

	public String getState() {
		return state.getLib_state();
	}

	public void setState(State state) {
		this.state = state;
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
