package com.example.projet.services;

import java.util.List;


import com.example.projet.entities.Employeur;

public interface EmployeurService {
	Employeur saveEmployee(Employeur emp);
	Employeur updateEmployee(Employeur emp);
	void deleteEmployee(Employeur emp);
	void deleteEmployeeById(int id);
	Employeur getEmployee(int id);
	List<Employeur> getAllEmployees();
	Employeur loginEmployeur(String email, String mdp);
	public boolean emailExists(String email);

}
