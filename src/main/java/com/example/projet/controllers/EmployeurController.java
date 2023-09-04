package com.example.projet.controllers;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.projet.entities.Admin;
import com.example.projet.entities.Candidat;
import com.example.projet.entities.Employeur;
import com.example.projet.entities.OffreEmploi;
import com.example.projet.services.AdminService;
import com.example.projet.services.EmployeurService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/employeurs")

public class EmployeurController {
	  private final EmployeurService employeurService;
	    private final AdminService adminService; // Ajoutez l'attribut pour AdminService


	    @Autowired
	    public EmployeurController(EmployeurService employeurService,AdminService adminService) {
	        this.employeurService = employeurService;
	        this.adminService = adminService;
	    }



	    @PostMapping
	    public ResponseEntity<Employeur> createEmployeur(@RequestBody Employeur employeur) {
	       
	        Employeur emp = employeurService.saveEmployee(employeur);

	        return ResponseEntity.status(HttpStatus.CREATED).body(emp);
	    }


	    @PatchMapping("/{id}")
	    public Employeur updateEmployeur(@PathVariable int id, @RequestBody Map<String, String> updates) {
	        Employeur employeur = employeurService.getEmployee(id);
	        
	        if (employeur == null) {
	            // Gérer le cas où l'employeur n'est pas trouvé avec l'ID spécifié
	            // Peut-être retourner une erreur 404 (NOT FOUND) ou autre traitement approprié.
	        }

	        // Mettre à jour les champs spécifiés dans le corps de la requête (dans le Map "updates")
	        if (updates.containsKey("nom")) {
	            employeur.setNom(updates.get("nom"));
	            employeur.setPrenom(updates.get("prenom"));
	            employeur.setNomentreprise(updates.get("nomentreprise"));
	            employeur.setEmail(updates.get("email"));
	            employeur.setMdp(updates.get("mdp"));
	        }
	        // Vous pouvez ajouter d'autres champs à mettre à jour ici

	        // Enregistrez les modifications en appelant la méthode de mise à jour du service
	        return employeurService.updateEmployee(employeur);
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEmployeur(@PathVariable int id) {
	    	  
	    	        Employeur emp = employeurService.getEmployee(id);
	    	        if (emp != null) {
	    	        	employeurService.deleteEmployeeById(id);
	    	            return ResponseEntity.noContent().build();
	    	        } else {
	    	            return ResponseEntity.notFound().build();
	    	        }
	    }

	    @GetMapping("/{id}")
	        public ResponseEntity<Employeur> getEmployeur(@PathVariable int id) {
	            Employeur emp = employeurService.getEmployee(id);
	            if (emp != null) {
	                return ResponseEntity.ok(emp);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	    }

	    @GetMapping
	    public List<Employeur> getAllEmployeurs() {
	        return employeurService.getAllEmployees();
	    }
	    

	    @GetMapping("/login")
	    public ResponseEntity<Map<String, String>> loginEmployeur(@RequestBody Map<String, String> requestParams) {
	        String email = requestParams.get("email");
	        String mdp = requestParams.get("mdp");

	        Employeur emp = employeurService.loginEmployeur(email, mdp);

	        if (emp != null) {
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
	    

}
