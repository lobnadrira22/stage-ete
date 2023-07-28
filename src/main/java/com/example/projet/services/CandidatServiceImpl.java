package com.example.projet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.entities.Candidat;
import com.example.projet.repos.CandidatRepository;

@Service
public class CandidatServiceImpl implements CandidatService{
	@Autowired
	CandidatRepository candidateRepo;
	@Override
	public Candidat saveCandidat(Candidat candidat) {
		
		return candidateRepo.save(candidat);
	}

	@Override
	public void registerCandidat(Candidat candidat) {
		/* Effectuer les contrôles de saisie */
        if (candidat.getNom() == null || candidat.getPrenom() == null ||
            candidat.getEmail() == null || candidat.getMdp() == null) {
            throw new IllegalArgumentException("Tous les champs obligatoires doivent être renseignés.");
        }

        if (!isValidEmail(candidat.getEmail())) {
            throw new IllegalArgumentException("Adresse email non valide.");
        }

        if (candidat.getMdp().length() < 8) {
            throw new IllegalArgumentException("Le mot de passe doit comporter au moins 8 caractères.");
        }

        /* Appeler la méthode saveCandidat pour enregistrer le candidat dans la base de données */
        candidateRepo.save(candidat);
        
    }
	private boolean isValidEmail(String email) {
        /* Votre logique de validation d'email ici */
        return true; /* Retourne true si l'email est valide, sinon false */
    }

	@Override
	public Candidat loginCandidat(String email, String mdp) {
		  /* Rechercher le candidat par son email dans la base de données */
        Candidat candidat = candidateRepo.findByEmail(email);

        /* Vérifier si le candidat existe et si le mot de passe est correct */
        if (candidat != null && candidat.getMdp().equals(mdp)) {
            return candidat; /* Authentification réussie, renvoie le candidat */
        }

        return null; /* Authentification échouée */
    }

}
