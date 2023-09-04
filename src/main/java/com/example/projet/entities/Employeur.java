package com.example.projet.entities;



import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


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





public Employeur(String nom, String prenom, String nomentreprise, String email, String mdp, Set<OffreEmploi> offres,
		Admin admin, Set<Calendrier> calendriers) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.nomentreprise = nomentreprise;
	this.email = email;
	this.mdp = mdp;
	this.offres = offres;
	this.admin = admin;
	this.calendriers = calendriers;
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
			+ nomentreprise + ", email=" + email + ", mdp=" + mdp + ", offres=" + offres + ", admin=" + admin
			+ ", calendriers=" + calendriers + "]";
}



@JsonIgnore
@OneToMany(mappedBy = "employeur") // This establishes the one-to-many relationship
// To prevent infinite recursion in JSON serialization (optional)
private Set<OffreEmploi> offres;

// Constructors, getters, setters, and other methods (omitted for brevity)

// Add the following method to manage the relationship
public void addOffreEmploi(OffreEmploi offreEmploi) {
    offres.add(offreEmploi);
    offreEmploi.setEmployeur(this);
}
@JsonIgnore
@ManyToOne // This establishes the many-to-one relationship
private Admin admin;// Reference to the employer managing this job offer

// Constructors, getters, setters, and other methods (omitted for brevity)

// Add the following method to manage the relationship
public void setAdmin(Admin admin){
    this.admin = admin;
}
public Admin getAdmin() {
    return admin;
}

@JsonIgnore
@OneToMany(mappedBy = "employeur")
private Set<Calendrier> calendriers;

public Set<Calendrier> getCalendriers() {
	return calendriers;
}

public void setCalendriers(Set<Calendrier> calendriers) {
	this.calendriers = calendriers;
}


public void addCalendrier(Calendrier calendrier) {
    calendriers.add(calendrier);
    calendrier.setEmployeur(this);
} 
}
