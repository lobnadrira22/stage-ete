package com.example.projet.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Candidature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date datecandidature;
	public Candidature() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidature(Date datecandidature) {
		super();
		this.datecandidature = datecandidature;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDatecandidature() {
		return datecandidature;
	}
	public void setDatecandidature(Date datecandidature) {
		this.datecandidature = datecandidature;
	}
	@Override
	public String toString() {
		return "Candidature [id=" + id + ", datecandidature=" + datecandidature + "]";
	}
	
	@ManyToOne
	@JoinColumn(name = "offreEmploi_id", referencedColumnName = "id")
	private OffreEmploi offreEmploi;

	public void setOffreEmploi(OffreEmploi offreEmploi) {
	    this.offreEmploi = offreEmploi;
	}

	@OneToOne
	@JoinColumn(name = "candidat_id", referencedColumnName = "id")
	private Candidat candidat;
 
	public void setCandidat(Candidat candidat) {
	    this.candidat = candidat;
	}


	
}
