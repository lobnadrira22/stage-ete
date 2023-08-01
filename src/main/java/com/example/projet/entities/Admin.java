package com.example.projet.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_admin;
private String email;
private String password;


public Admin() {
	super();
	// TODO Auto-generated constructor stub
}



public Admin(String email, String password, String role) {
	super();
	this.email = email;
	this.password = password;
	}



public Long getId_admin() {
	return id_admin;
}
public void setId_admin(Long id_admin) {
	this.id_admin = id_admin;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



@Override
public String toString() {
	return "Admin [id_admin=" + id_admin + ", email=" + email + ", password=" + password +  "]";
}

@OneToMany(mappedBy = "admin") 
@JsonIgnore 
private Set<Employeur> employees;


public void addEmployeur(Employeur emp) {
    employees.add(emp);
    emp.setAdmin(this);
}


}
