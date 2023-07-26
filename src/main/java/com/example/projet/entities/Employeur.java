package com.example.projet.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employeur {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
private int idEmployeur;
private String nom;
private String prenom;
private String nomentreprise;
private String email;
private String mdp;


public Employeur() {
	super();
	// TODO Auto-generated constructor stub
}

public Employeur(String nom, String prenom, String nomentreprise, String email, String mdp) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.nomentreprise = nomentreprise;
	this.email = email;
	this.mdp = mdp;
}

public int getIdEmployeur() {
	return idEmployeur;
}
public void setIdEmployeur(int idEmployeur) {
	this.idEmployeur = idEmployeur;
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
public String getNomentreprise() {
	return nomentreprise;
}
public void setNomentreprise(String nomentreprise) {
	this.nomentreprise = nomentreprise;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}

@Override
public String toString() {
	return "Employeur [idEmployeur=" + idEmployeur + ", nom=" + nom + ", prenom=" + prenom + ", nomentreprise="
			+ nomentreprise + ", email=" + email + ", mdp=" + mdp + "]";
}


}
