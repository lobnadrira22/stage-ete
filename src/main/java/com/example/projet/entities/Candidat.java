package com.example.projet.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Candidat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String photo;
	private String numtel;
	private String email;
	private String mdp;
	private Collection<String> dossier;
	private Long cin;
	private String CV;
	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidat(String nom, String prenom, String photo, String numtel, String email, String mdp,
			Collection<String> dossier, Long cin, String cV) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.photo = photo;
		this.numtel = numtel;
		this.email = email;
		this.mdp = mdp;
		this.dossier = dossier;
		this.cin = cin;
		CV = cV;
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
	public String getNumtel() {
		return numtel;
	}
	public void setNumtel(String numtel) {
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
	public Collection<String> getDossier() {
		return dossier;
	}
	public void setDossier(Collection<String> dossier) {
		this.dossier = dossier;
	}
	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	public String getCV() {
		return CV;
	}
	public void setCV(String cV) {
		CV = cV;
	}
	@Override
	public String toString() {
		return "Candidat [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", photo=" + photo + ", numtel=" + numtel
				+ ", email=" + email + ", mdp=" + mdp + ", dossier=" + dossier + ", cin=" + cin + ", CV=" + CV + "]";
	}
	
	
	
	

}
