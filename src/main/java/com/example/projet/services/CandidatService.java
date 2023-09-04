package com.example.projet.services;

import java.util.List;

import com.example.projet.entities.Candidat;

public interface CandidatService {
void registerCandidat(Candidat candidat);
Candidat loginCandidat(String email, String mdp);
public Candidat saveCandidat(Candidat candidat);
public Candidat updateProfileCandidat(Candidat candidat);
public Candidat postuler(Candidat candidat);
public List<Candidat> getAllcandidats();
public Candidat getCandidat(int id);
public boolean emailExists(String email);
}
