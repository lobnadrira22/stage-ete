package com.example.projet.services;

import com.example.projet.entities.Candidat;

public interface CandidatService {
void registerCandidat(Candidat candidat);
Candidat loginCandidat(String email, String mdp);
public Candidat saveCandidat(Candidat candidat);
}
