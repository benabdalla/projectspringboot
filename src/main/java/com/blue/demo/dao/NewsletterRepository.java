package com.blue.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blue.demo.entities.Newsletter;


public interface NewsletterRepository extends JpaRepository <Newsletter, Long>{

}

