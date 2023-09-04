package com.example.projet.controllers;

import com.example.projet.entities.Candidat;


import com.example.projet.services.CandidatService;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/candidats")

public class CandidatController {
	private final CandidatService candidatService;

    @Autowired
    public CandidatController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCandidat(@RequestBody Candidat candidat) {
        // Vérifier si l'email existe déjà dans la base de données
        if (candidatService.emailExists(candidat.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cet email est déjà utilisé");
        }

        // Si l'email n'existe pas, procéder à l'inscription
        Candidat registeredCandidat = candidatService.saveCandidat(candidat);
        return ResponseEntity.ok(registeredCandidat);
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginCandidat(@RequestBody Map<String, String> requestParams) {
        String email = requestParams.get("email");
        String mdp = requestParams.get("mdp");

        Candidat candidat = candidatService.loginCandidat(email, mdp);

        if (candidat != null) {
            // Authentification réussie, renvoyer un message "Vous êtes connecté"
            Map<String, String> response = new HashMap<>();
            response.put("message", "Vous êtes connecté");
            return ResponseEntity.ok(response);
        } else {
            // Authentification échouée, renvoyer un message "Essayez encore"
            Map<String, String> response = new HashMap<>();
            response.put("message", "Essayez encore");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
    @PutMapping("/update")
    public Candidat updateProfileCandidat(@RequestBody Candidat candidat) {
        return candidatService.updateProfileCandidat(candidat);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Candidat> updateProfileCandidat(@PathVariable int id, @RequestBody Map<String, String> updates) {
        Candidat candidat = candidatService.getCandidat(id);

        if (candidat == null) {
            // If the candidat is not found with the specified ID, return a 404 response.
            return ResponseEntity.notFound().build();
        }

        // Update the specified fields from the request body (from the "updates" map)
        if (updates.containsKey("domaine")) {
            candidat.setDomaine(updates.get("domaine"));
        }
        
        if (updates.containsKey("cin") && updates.containsKey("numtel")) {
            String cinValue = updates.get("cin");
            String numtelValue = updates.get("numtel");
            try {
                long cin = Long.parseLong(cinValue);
                int numtel = Integer.parseInt(numtelValue);
                candidat.setCin(cin);
                candidat.setNumtel(numtel);
            } catch (NumberFormatException e) {
                // Handle the case where the cin or numtel value is not a valid number.
                // You can return an appropriate error response here.
                return ResponseEntity.badRequest().build();
            }
        }

        // You can add more fields to update here.

        // Save the changes by calling the updateProfileCandidat method in the service.
        Candidat updatedCandidat = candidatService.updateProfileCandidat(candidat);

        // Return the updated candidat with a 200 OK response.
        return ResponseEntity.ok(updatedCandidat);
    }

   /* @PostMapping("/postuler")
    public ResponseEntity<String> postuler(
            @RequestPart("CV") MultipartFile CVFile,
            @RequestPart("lettremotivation") MultipartFile lettremotivationFile) {

    	try {
    	    String CVFileName = generateRandomFileName() + ".pdf";
    	    String lettremotivationFileName = generateRandomFileName() + ".pdf";

    	    // Save CV file
    	    String CVFilePath = "src/main/resources/files/CV/" + CVFileName;
    	    Files.write(Paths.get(CVFilePath), CVFile.getBytes());

    	    // Save lettre de motivation file
    	    String lettremotivationFilePath = "src/main/resources/files/lettremotivation/" + lettremotivationFileName;
    	    Files.write(Paths.get(lettremotivationFilePath), lettremotivationFile.getBytes());

    	    // Create and save Candidat object
    	    Candidat newCandidat = new Candidat();
    	    newCandidat.setCV(CVFileName);
    	    newCandidat.setLettremotivation(lettremotivationFileName);
    	    candidatService.postuler(newCandidat);

    	    return ResponseEntity.ok("Postulation réussie");
    	} catch (Exception e) {
    	    return ResponseEntity.status(500).body("Erreur lors de la postulation : " + e.getMessage());
    	}
    }
    */






    // Méthode pour générer un nom de fichier aléatoire
   /* private String generateRandomFileName() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomFileName = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = (int) (Math.random() * characters.length());
            randomFileName.append(characters.charAt(index));
        }
        return randomFileName.toString();
    }   */

@GetMapping
public ResponseEntity<List<Candidat>> getAllcandidats() {
    List<Candidat> candidats = candidatService.getAllcandidats();
    return ResponseEntity.ok(candidats);
}

@GetMapping("/{id}")
public ResponseEntity<Candidat> getCandidatById(@PathVariable int id) {
    Candidat can = candidatService.getCandidat(id);
    if (can != null) {
        return ResponseEntity.ok(can);
    } else {
        return ResponseEntity.notFound().build();
    }
}

@GetMapping("/logout")
public ResponseEntity<String> logoutCandidat() {
    // Ici, vous pouvez implémenter la logique de déconnexion
    // Cela peut inclure l'invalidation de la session, la suppression des cookies, etc.

    // Pour cet exemple, nous allons simplement renvoyer un message de déconnexion réussie.
    return ResponseEntity.ok("Vous êtes déconnecté");
}


}

