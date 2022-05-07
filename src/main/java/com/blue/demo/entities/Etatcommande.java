package com.blue.demo.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Etatcommande {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_etatcmd;
	
	private String etatcmd;
	
	@OneToMany(mappedBy="etatcommande")
	private Set<Commande> Commande;

	public Long getId_etatcmd() {
		return id_etatcmd;
	}

	public void setId_etatcmd(Long id_etatcmd) {
		this.id_etatcmd = id_etatcmd;
	}

	public String getEtatcmd() {
		return etatcmd;
	}

	public void setEtatcmd(String etatcmd) {
		this.etatcmd = etatcmd;
	}



	public void setCommande(Set<Commande> commande) {
		Commande = commande;
	}

	public Etatcommande(String etatcmd, Set<com.blue.demo.entities.Commande> commande) {
		super();
		this.etatcmd = etatcmd;
		Commande = commande;
	}

	public Etatcommande() {
		super();
	}
	
	

	
}
