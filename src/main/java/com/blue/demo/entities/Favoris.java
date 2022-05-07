package com.blue.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(IdFavoris.class)
public class Favoris {

	 
	 @Id
	 @ManyToOne
	    @JoinColumn(name = "id_user")
	    User user;
	    
	 @Id
	    @ManyToOne
	    @JoinColumn(name = "id_article")
	    Article article;

		 
 
 

	 

		public Long getUser() {
			return user.getId_user();
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Article getArticle() {
			return article;
		}

		public void setArticle(Article article) {
			this.article = article;
		}

		public Favoris(User user, Article article) {
			super();
			this.user = user;
			this.article = article;
		}

		public Favoris() {
			super();
			// TODO Auto-generated constructor stub
		}
	
	    
	    
}
