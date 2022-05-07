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
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cmd;
	
	private double prix_total;
	private String  date_cmd;
	private String  date_limit;
	private String  tel_commande;

	
	@ManyToOne
    @JoinColumn(name = "id_adresse")
    Adresse adresse;
	
	@ManyToOne 
	@JoinColumn (name="id_user")
	private User user;
	
	@OneToMany(mappedBy="commande")
	private Set<Livraison> livraison;
	
	@ManyToOne 
	@JoinColumn (name="id_etatcmd")
	private Etatcommande etatcommande;
	
	@ManyToOne 
	@JoinColumn (name="id_modeliv")
	private Modelivraison modelivraison;
	
	@ManyToOne 
	@JoinColumn (name="id_boutique")
	private Boutique boutique;
	
	 @OneToMany(mappedBy = "commande")
	    Set<Commande_prod> commande_prod=new HashSet<>();;
 
	 
	public void setEtatcommande(Etatcommande etatcommande) {
		this.etatcommande = etatcommande;
	}
	public Long getId_cmd() {
		return id_cmd;
	}
	public void setId_cmd(Long id_cmd) {
		this.id_cmd = id_cmd;
	}
	


	
	 
	public Etatcommande getEtatcommande() {
		return etatcommande;
	}
	public Set<Commande_prod> getCommande_prod() {
		return commande_prod;
	}
	public void setCommande_prod(Set<Commande_prod> commande_prod) {
		this.commande_prod = commande_prod;
	}

	
	public Commande(double prix_total, String date_cmd, String date_limit, String tel_commande, Adresse adresse,
			User user, Etatcommande etatcommande, Modelivraison modelivraison, Boutique boutique,
			Set<Commande_prod> commande_prod) {
		super();
		this.prix_total = prix_total;
		this.date_cmd = date_cmd;
		this.date_limit = date_limit;
		this.tel_commande = tel_commande;
		this.adresse = adresse;
		this.user = user;
		this.etatcommande = etatcommande;
		this.modelivraison = modelivraison;
		this.boutique = boutique;
		this.commande_prod = commande_prod;
	}
	public String getDate_limit() {
		return date_limit;
	}
	public void setDate_limit(String date_limit) {
		this.date_limit = date_limit;
	}
	public long getModelivraison() {
		return modelivraison.getId_modeliv();
	}
	public void setModelivraison(Modelivraison modelivraison) {
		this.modelivraison = modelivraison;
	}
	public Boutique getBoutique() {
		return boutique;
	}
	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}
	public double getPrix_total() {
		return prix_total;
	}
	public void setPrix_total(double prix_total) {
		this.prix_total = prix_total;
	}
	public String getDate_cmd() {
		return date_cmd;
	}
	public void setDate_cmd(String date_cmd) {
		this.date_cmd = date_cmd;
	}
		
	
	
	
	 

	public String getTel_commande() {
		return tel_commande;
	}
	public void setTel_commande(String tel_commande) {
		this.tel_commande = tel_commande;
	}

	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Long getUser() {
		return user.getId_user();
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Commande() {
		super();
	}
	
}
