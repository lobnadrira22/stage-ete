package com.example.projet.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projet.entities.Admin;
import com.example.projet.entities.Employeur;



@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	 Admin findByEmail(String email);
}
