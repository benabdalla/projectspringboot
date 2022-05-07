package com.blue.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commande_prod {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_commande_prod;
	
	 
	    String taille;
	 
	    @ManyToOne
	    @JoinColumn(name = "id_article")
	    Article article;
	    
	    @ManyToOne
	    @JoinColumn(name = "id_cmd")
	    Commande commande;
	 
	    private int quantite;
	    private double sous_total;	
	   



		public Commande_prod(String taille, Article article, Commande commande, int quantite, double sous_total) {
			super();
			this.taille = taille;
			this.article = article;
			this.commande = commande;
			this.quantite = quantite;
			this.sous_total = sous_total;
		}





		public String getTaille() {
			return taille;
		}





		public void setTaille(String taille) {
			this.taille = taille;
		}





		public Commande_prod() {
			super();
			// TODO Auto-generated constructor stub
		}



	 

		public double getSous_total() {
			return sous_total;
		}



		public void setSous_total(double sous_total) {
			this.sous_total = sous_total;
		}



		public Long getId_commande_prod() {
			return id_commande_prod;
		}

		public void setId_commande_prod(Long id_commande_prod) {
			this.id_commande_prod = id_commande_prod;
		}

	 

		public Article getArticle() {
			return article ;
		}

		public void setArticle(Article article) {
			this.article = article;
		}

		public long getCommande() {
			return commande.getId_cmd();
		}

		public void setCommande(Commande commande) {
			this.commande = commande;
		}

		public int getQuantite() {
			return quantite;
		}

		public void setQuantite(int quantite) {
			this.quantite = quantite;
		} 
	    
	    
	    
	  
}
