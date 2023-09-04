package com.example.projet.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.projet.entities.Employeur;

public interface EmployeurRepository extends JpaRepository<Employeur, Integer> {
	 Employeur findByEmail(String email);
}
