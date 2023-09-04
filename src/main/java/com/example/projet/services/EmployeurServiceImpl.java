package com.example.projet.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.projet.entities.Employeur;
import com.example.projet.repos.EmployeurRepository;

@Service
public class EmployeurServiceImpl implements EmployeurService {

	@Autowired
	EmployeurRepository emprep;
	@Override
	public Employeur saveEmployee(Employeur emp) {
		
		return emprep.save(emp);
	}

	@Override
	public Employeur updateEmployee(Employeur emp) {
		return emprep.save(emp);
	}

	@Override
	public void deleteEmployee(Employeur emp) {
		 emprep.delete(emp);
		
	}

	@Override
	public void deleteEmployeeById(int id) {
		emprep.deleteById(id);
		
	}

	@Override
	public Employeur getEmployee(int id) {
		// TODO Auto-generated method stub
		return emprep.findById(id).get();
		
	}

	@Override
	public List<Employeur> getAllEmployees() {
		
		return emprep.findAll();
	}

	@Override
	public Employeur loginEmployeur(String email, String mdp) {
		 /* Rechercher le candidat par son email dans la base de données */
        Employeur emp = emprep.findByEmail(email);

        /* Vérifier si le candidat existe et si le mot de passe est correct */
        if (emp != null && emp.getMdp().equals(mdp)) {
            return emp; /* Authentification réussie, renvoie le candidat */
        }

        return null; /* Authentification échouée */
	}

	@Override
	public boolean emailExists(String email) {
		 return emprep.findByEmail(email) != null;
	}

}
