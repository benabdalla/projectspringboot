package com.blue.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	
	private String nom;
	private String prenom;
	private String tel;
  	
	 
	  @OneToMany(mappedBy = "user")
	    Set<Favoris> favoris=new HashSet<>();

	  @OneToMany(mappedBy="user")
		private Set<Livraison> Livraison;
	
	  
	@ManyToOne 
	@JoinColumn (name="id_privilege")
	private Privilege privilege;
	
 
	 @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "id_compte", referencedColumnName = "id_compte")
	    private Compte compte;

	
	@ManyToOne
    @JoinColumn(name = "id_adresse")
    Adresse adresse;

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}


	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	 

	public User(String nom, String prenom, String tel,    Privilege privilege,
			Compte compte,  Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
  		this.privilege = privilege;
		this.compte = compte;
 		this.adresse = adresse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Favoris> getFavoris() {
		return favoris;
	}

	public void setFavoris(Set<Favoris> favoris) {
		this.favoris = favoris;
	}



	
	
	
}
