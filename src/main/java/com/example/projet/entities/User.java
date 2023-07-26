package com.example.projet.entities;

public class User {

private Long id_user;
private String email;
private String password;
private String role;

public User() {
	super();
	// TODO Auto-generated constructor stub
}



public User(String email, String password, String role) {
	super();
	this.email = email;
	this.password = password;
	this.role = role;
}



public Long getId_user() {
	return id_user;
}
public void setId_user(Long id_user) {
	this.id_user = id_user;
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
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}



@Override
public String toString() {
	return "User [id_user=" + id_user + ", email=" + email + ", password=" + password + ", role=" + role + "]";
}




}
