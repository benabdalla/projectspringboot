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
public class Livraison {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_livraison;
	
	private String date_livraison;

	
	
	@ManyToOne 
	@JoinColumn (name="id_user")
	private User user;
	
	@ManyToOne 
	@JoinColumn (name="id_cmd")
	private Commande commande;
	
	
 

		public String getDate_livraison() {
		return date_livraison;
	}
	public void setDate_livraison(String date_livraison) {
		this.date_livraison = date_livraison;
	}


	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Long getId_livraison() {
		return id_livraison;
	}
	public void setId_livraison(Long id_livraison) {
		this.id_livraison = id_livraison;
	}
	
	
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	 
	
	
	
	public Livraison(String date_livraison, User user, Commande commande) {
		super();
		this.date_livraison = date_livraison;
		this.user = user;
		this.commande = commande;
	}
	public Livraison() {
		super();
	}
	
	
	
}
