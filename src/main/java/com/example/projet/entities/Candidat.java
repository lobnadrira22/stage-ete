package com.example.projet.entities;



import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Candidat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String photo;
	private int numtel;
	private String email;
	private String mdp;
	private String domaine;
	private Long cin;
	
	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidat(String nom, String prenom, String photo, int numtel, String email, String mdp,
			String dossier, Long cin, String cV) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.numtel = numtel;
		this.email = email;
		this.mdp = mdp;
		
		this.cin = cin;
		
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getNumtel() {
		return numtel;
	}
	public void setNumtel(int numtel) {
		this.numtel = numtel;
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
	
	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getDomaine() {
		return domaine;
	}
	
	
	
	@Override
	public String toString() {
		return "Candidat [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", photo=" + photo + ", numtel=" + numtel
				+ ", email=" + email + ", mdp=" + mdp + ", domaine=" + domaine + ", cin=" + cin + ", candidatures="
				+ candidatures + "]";
	}



	@JsonIgnore
	@OneToMany(mappedBy = "candidat")
	private Set<Candidature> candidatures;
	
	public void addCandidature(Candidature candidature) {
	    candidatures.add(candidature);
	    candidature.setCandidat(this);
	}
	public Set<Candidature> getCandidatures() {
		return candidatures;
	}
	public void setCandidatures(Set<Candidature> candidatures) {
		this.candidatures = candidatures;
	}
	


	

}
