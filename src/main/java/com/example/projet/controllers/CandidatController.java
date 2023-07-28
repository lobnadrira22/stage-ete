package com.example.projet.controllers;

import com.example.projet.entities.Candidat;
import com.example.projet.services.CandidatService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidats")

public class CandidatController {
	private final CandidatService candidatService;

    @Autowired
    public CandidatController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    @PostMapping("/register")
    public Candidat registerCandidat(@RequestBody Candidat candidat) {
        return candidatService.saveCandidat(candidat);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCandidat(@RequestBody Map<String, String> requestParams) {
        String email = requestParams.get("email");
        String mdp = requestParams.get("mdp");

        Candidat candidat = candidatService.loginCandidat(email, mdp);

        if (candidat != null) {
            // Authentification réussie, renvoyer un message "Vous êtes connecté"
            return ResponseEntity.ok("Vous êtes connecté");
        } else {
            // Authentification échouée, renvoyer un message "Essayez encore"
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Essayez encore");
        }
    }

}

