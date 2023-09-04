package com.example.projet.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Candidature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date datecandidature;
	private int note;
	private String lettremotivation;
	private String CV;
	public Candidature() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Candidature(Date datecandidature, int note, String lettremotivation, String CV, OffreEmploi offreEmploi
			) {
		super();
		this.datecandidature = datecandidature;
		this.note = note;
		this.lettremotivation = lettremotivation;
		this.CV = CV;
		this.offreEmploi = offreEmploi;
		
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
	
	

	public String getLettremotivation() {
		return lettremotivation;
	}

	public void setLettremotivation(String lettremotivation) {
		this.lettremotivation = lettremotivation;
	}

	public String getCV() {
		return CV;
	}

	public void setCV(String cV) {
		CV = cV;
	}

	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	


	
	@Override
	public String toString() {
		return "Candidature [id=" + id + ", datecandidature=" + datecandidature + ", note=" + note
				+ ", lettremotivation=" + lettremotivation + ", CV=" + CV + ", offreEmploi=" + offreEmploi
				+ ", candidat=" + candidat + "]";
	}

	public OffreEmploi getOffreEmploi() {
		return offreEmploi;
	}
	public Candidat getCandidat() {
		return candidat;
	}


    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "offreEmploi_id", referencedColumnName = "id")
	private OffreEmploi offreEmploi;

	public void setOffreEmploi(OffreEmploi offreEmploi) {
	    this.offreEmploi = offreEmploi;
	}
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "candidat_id", referencedColumnName = "id")
	private Candidat candidat;
 
	public void setCandidat(Candidat candidat) {
	    this.candidat = candidat;
	}


	
}
