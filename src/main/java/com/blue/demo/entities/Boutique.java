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
public class Boutique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_boutique;
	
	private String tel_boutique;
	private String mail_boutique;
	private String description_boutique;
	private String lib_boutique;
	
	
	@ManyToOne
    @JoinColumn(name = "id_adresse")
    Adresse adresse;

 

 
 
	public Long getId_boutique() {
		return id_boutique;
	}

	public void setId_boutique(Long id_boutique) {
		this.id_boutique = id_boutique;
	}

	public String getTel_boutique() {
		return tel_boutique;
	}

	public void setTel_boutique(String tel_boutique) {
		this.tel_boutique = tel_boutique;
	}

	public String getMail_boutique() {
		return mail_boutique;
	}

	public void setMail_boutique(String mail_boutique) {
		this.mail_boutique = mail_boutique;
	}

	

	public String getDescription_boutique() {
		return description_boutique;
	}

	public void setDescription_boutique(String description_boutique) {
		this.description_boutique = description_boutique;
	}

	public String getLib_boutique() {
		return lib_boutique;
	}

	public void setLib_boutique(String lib_boutique) {
		this.lib_boutique = lib_boutique;
	}

	

	
	public Adresse getAdresse() {
		
		return adresse ;
		
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	

	public Boutique(String tel_boutique, String mail_boutique, String description_boutique, String lib_boutique,
			Adresse adresse) {
		super();
		this.tel_boutique = tel_boutique;
		this.mail_boutique = mail_boutique;
		this.description_boutique = description_boutique;
		this.lib_boutique = lib_boutique;
		this.adresse = adresse;
 	}

	public Boutique() {
		super();
	}

	
	
}
