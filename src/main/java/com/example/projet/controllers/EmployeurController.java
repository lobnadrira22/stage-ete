package com.example.projet.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.projet.entities.Admin;
import com.example.projet.entities.Employeur;
import com.example.projet.services.AdminService;
import com.example.projet.services.EmployeurService;
import java.util.List;
import java.util.Map;

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
	    public Employeur createEmployeur(@RequestBody Employeur employeur, @RequestParam("adminId") Long adminId) {
	        Admin admin = adminService.getAdmin(adminId);

	        if (admin == null) {
	            throw new RuntimeException("Administrateur introuvable avec l'ID spécifié : " + adminId);
	        }

	        employeur.setAdmin(admin);

	        return employeurService.saveEmployee(employeur);
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
	    public void deleteEmployeur(@PathVariable int id) {
	        employeurService.deleteEmployeeById(id);
	    }

	    @GetMapping("/{id}")
	    public Employeur getEmployeur(@PathVariable int id) {
	        return employeurService.getEmployee(id);
	    }

	    @GetMapping
	    public List<Employeur> getAllEmployeurs() {
	        return employeurService.getAllEmployees();
	    }

}
