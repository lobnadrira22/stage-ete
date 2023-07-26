package com.example.projet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projet.entities.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat, Integer> {

}
