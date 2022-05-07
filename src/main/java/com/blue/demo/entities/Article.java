package com.blue.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.boot.autoconfigure.domain.EntityScan;


@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_article;
	private float prix;
	private double taux_tva;
	private double taux_remise;
	private String img_article;
	private String description_article;
	private double note;
	private String designation;
	 @Column(columnDefinition = "boolean default true")
	    private Boolean active;

	  @OneToMany(mappedBy = "article")
	    Set<Favoris> favoris=new HashSet<>();;
    
	  @OneToMany(mappedBy = "article")
	    Set<Taille_prod> taille_prod=new HashSet<>();;
	
		@ManyToOne 
		@JoinColumn (name="id_categorie")
		private Categorie categorie;
		
		@ManyToOne 
		@JoinColumn (name="id_gender")
		private Gender gender;
		
	public Article() {
			super();
		}

	public Article(float prix,  double taux_tva, double taux_remise, String img_article,
			String description_article, double note, String designation, Set<Taille_prod> taille_prod,
			Categorie categorie, Gender gender) {
		super();
		this.prix = prix;
 		this.taux_tva = taux_tva;
		this.taux_remise = taux_remise;
		this.img_article = img_article;
		this.description_article = description_article;
		this.note = note;
		this.designation = designation;
		this.taille_prod = taille_prod;
		this.categorie = categorie;
		this.gender = gender;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getId_article() {
		return id_article;
	}

	public void setId_article(Long id_article) {
		this.id_article = id_article;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public double getTaux_tva() {
		return taux_tva;
	}

	public void setTaux_tva(double taux_tva) {
		this.taux_tva = taux_tva;
	}

	public double getTaux_remise() {
		return taux_remise;
	}

	public void setTaux_remise(double taux_remise) {
		this.taux_remise = taux_remise;
	}



	public String getImg_article() {
		return img_article;
	}



	public void setImg_article(String img_article) {
		this.img_article = img_article;
	}



	public String getDescription_article() {
		return description_article;
	}



	public void setDescription_article(String description_article) {
		this.description_article = description_article;
	}



	public double getNote() {
		return note;
	}



	public void setNote(double note) {
		this.note = note;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public Set<Taille_prod> getTaille_prod() {
		return taille_prod;
	}


	public void setTaille_prod(Set<Taille_prod> taille_prod) {
		this.taille_prod = taille_prod;
	}



	public Categorie getCategorie() {
		return categorie;
	}



	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}






	public void setFavoris(Set<Favoris> favoris) {
		this.favoris = favoris;
	}

	
	
	
}
