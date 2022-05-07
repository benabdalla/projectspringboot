package com.blue.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Taille_prod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id_taille_prod;
 
    @ManyToOne
    @JoinColumn(name = "id_taille")
    Taille taille;
 
    @ManyToOne
    @JoinColumn(name = "id_article")
    Article article;
    
    
 
    int Quantite;
 
	public Taille_prod() {
		super();
	}

	public Taille_prod(Taille taille, Article article, int quantite) {
		super();
		this.taille = taille;
		this.article = article;
		Quantite = quantite;
	}

	public Long getId_taille_prod() {
		return Id_taille_prod;
	}

	public void setId_taille_prod(Long id_taille_prod) {
		Id_taille_prod = id_taille_prod;
	}

	public Taille getTaille() {
		return taille;
	}

	public void setTaille(Taille taille) {
		this.taille = taille;
	}

 
	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantite() {
		return Quantite;
	}

	public void setQuantite(int quantite) {
		Quantite = quantite;
	}
 
    
}