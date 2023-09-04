package com.example.projet.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Calendrier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
private int id;
private LocalDate dateEntretien;
private String description;
public Calendrier() {
	super();
	// TODO Auto-generated constructor stub
}
public Calendrier(LocalDate dateEntretien, String description) {
	super();
	this.dateEntretien = dateEntretien;
	this.description = description;
}

public Calendrier(LocalDate dateEntretien, String description, Employeur employeur) {
	super();
	this.dateEntretien = dateEntretien;
	this.description = description;
	this.employeur = employeur;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public LocalDate getDateEntretien() {
	return dateEntretien;
}
public void setDateEntretien(LocalDate dateEntretien) {
	this.dateEntretien = dateEntretien;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}


@Override
public String toString() {
	return "Calendrier [id=" + id + ", dateEntretien=" + dateEntretien + ", description=" + description + ", employeur="
			+ employeur + "]";
}

@JsonIgnore
@ManyToOne 
private Employeur employeur;
public void setEmployeur(Employeur employeur) {
	 this.employeur = employeur;
	
}
public Employeur getEmployeur() {
    return employeur;
}
}
