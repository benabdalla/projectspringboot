package com.blue.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Newsletter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_news;
	private String email;
	public Long getId_news() {
		return id_news;
	}
	public void setId_news(Long id_news) {
		this.id_news = id_news;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Newsletter(String email) {
		super();
		this.email = email;
	}
	public Newsletter() {
		super();
		// TODO Auto-generated constructor stub
	}

}
