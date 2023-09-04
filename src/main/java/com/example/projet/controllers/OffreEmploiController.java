package com.example.projet.controllers;







import java.util.List;
import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import com.example.projet.entities.Employeur;
import com.example.projet.entities.OffreEmploi;
import com.example.projet.services.OffreEmploiService;

import jakarta.persistence.ManyToOne;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/offres")
public class OffreEmploiController {

    private final OffreEmploiService offreEmploiService;
   

 
    
    
   
    @Autowired
    public OffreEmploiController(OffreEmploiService offreEmploiService) {
        this.offreEmploiService = offreEmploiService;
    }

    @PostMapping
    public ResponseEntity<OffreEmploi> createOffreEmploi(@RequestBody OffreEmploi offreEmploi) {
        // Save the offreEmploi object
        OffreEmploi savedOffre = offreEmploiService.saveOffre(offreEmploi);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOffre);
    }

    @GetMapping
    public ResponseEntity<List<OffreEmploi>> getAllOffres() {
        List<OffreEmploi> offres = offreEmploiService.getAllOffres();
        return ResponseEntity.ok(offres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OffreEmploi> getOffreEmploiById(@PathVariable int id) {
        OffreEmploi offre = offreEmploiService.getOffre(id);
        if (offre != null) {
            return ResponseEntity.ok(offre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OffreEmploi> updateOffreEmploi(@PathVariable int id, @RequestBody OffreEmploi offreEmploi) {
    	try {
            OffreEmploi existingOffre = offreEmploiService.getOffre(id);

            if (existingOffre != null) {
                
            
            // Mise à jour des attributs de existingOffre avec ceux de offreEmploi
            existingOffre.setNom(offreEmploi.getNom());
            existingOffre.setImage(offreEmploi.getImage());
            existingOffre.setCategorieoffre(offreEmploi.getCategorieoffre());
            existingOffre.setDescription(offreEmploi.getDescription());
            existingOffre.setDateexpiration(offreEmploi.getDateexpiration());
            // N'oubliez pas d'ajouter d'autres mises à jour si nécessaire
            
            // Mettre à jour existingOffre dans le service
            OffreEmploi updatedOffre = offreEmploiService.updateOffre(existingOffre);
            return ResponseEntity.ok(updatedOffre);
        } else {
            return ResponseEntity.notFound().build();
        }
    } catch (NoSuchElementException e) {
        return ResponseEntity.notFound().build();
    }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffreEmploi(@PathVariable int id) {
        OffreEmploi offre = offreEmploiService.getOffre(id);
        if (offre != null) {
            offreEmploiService.deleteOffreById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @ManyToOne
    private Employeur emp;
}
