package com.example.projet.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class OffreEmploi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String description;
	private Date dateexpiration;
	public OffreEmploi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OffreEmploi(String nom, String description, Date dateexpiration) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateexpiration = dateexpiration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateexpiration() {
		return dateexpiration;
	}
	public void setDateexpiration(Date dateexpiration) {
		this.dateexpiration = dateexpiration;
	}
	@Override
	public String toString() {
		return "OffreEmploi [id=" + id + ", nom=" + nom + ", description=" + description + ", dateexpiration="
				+ dateexpiration + "]";
	}
	@ManyToOne // This establishes the many-to-one relationship
    private Employeur employeur; // Reference to the employer managing this job offer

    // Constructors, getters, setters, and other methods (omitted for brevity)

    // Add the following method to manage the relationship
    public void setEmployeur(Employeur employeur) {
        this.employeur = employeur;
    }
    public Employeur getEmployeur() {
        return employeur;
    }

	
    @OneToMany(mappedBy = "offreEmploi", cascade = CascadeType.ALL)
    private List<Candidature> candidatures;
    public void addCandidature(Candidature candidature) {
        if (candidatures == null) {
            candidatures = new ArrayList<>();
        }
        candidatures.add(candidature);
        candidature.setOffreEmploi(this);
    }

    public void removeCandidature(Candidature candidature) {
        if (candidatures != null) {
            candidatures.remove(candidature);
            candidature.setOffreEmploi(null);
        }
    }

	
	
}
