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
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_state;
	private String lib_state;

	@OneToMany(mappedBy = "state")
    Set<City> City=new HashSet<>();

	public Long getId_state() {
		return id_state;
	}

	public void setId_state(Long id_state) {
		this.id_state = id_state;
	}

	public String getLib_state() {
		return lib_state;
	}

	public void setLib_state(String lib_state) {
		this.lib_state = lib_state;
	}

	




	public Set<City> getCity() {
		return City;
	}

	public void setCity(Set<City> city) {
		City = city;
	}

	public State(String lib_state, Set<com.blue.demo.entities.City> city) {
		super();
		this.lib_state = lib_state;
		City = city;
	}

	public State() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
