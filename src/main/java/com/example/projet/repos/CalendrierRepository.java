package com.example.projet.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projet.entities.Calendrier;


public interface CalendrierRepository extends JpaRepository<Calendrier, Integer> {

}
