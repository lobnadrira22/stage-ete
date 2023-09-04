package com.example.projet.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.projet.entities.Admin;
import com.example.projet.entities.Employeur;
import com.example.projet.services.AdminService;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/admin")

public class AdminController {
	  private final AdminService adminservice;

	    @Autowired
	    public AdminController(AdminService adminservice) {
	        this.adminservice = adminservice;
	    }

	    @PostMapping
	    public Admin createAdmin(@RequestBody Admin admin) {
	        return adminservice.saveAdmin(admin);
	    }

	    @PatchMapping("/{id}")
	    public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Map<String, String> updates) {
	        Admin admin = adminservice.getAdmin(id);
	        
	        if (admin == null) {
	            return ResponseEntity.notFound().build();
	        }

	        
	        if (updates.containsKey("email")) {
	            admin.setEmail(updates.get("email"));
	        }
	        if (updates.containsKey("password")) {
	            admin.setPassword(updates.get("password"));
	        }
	       
	        Admin updatedAdmin = adminservice.updateAdmin(admin);
	        return ResponseEntity.ok(updatedAdmin);
	    }

	

	    @GetMapping("/{id}")
	    public Admin getAdmin(@PathVariable int id) {
	        return adminservice.getAdmin(id);
	    }

	  /*  @GetMapping
	    public List<Employeur> getAllEmployeurs() {
	        return employeurService.getAllEmployees();
	    } */
	    
	    @GetMapping("/login")
	    public ResponseEntity<Map<String, String>> loginAdmin(@RequestBody Map<String, String> requestParams) {
	        String email = requestParams.get("email");
	        String password = requestParams.get("password");

	        Admin adm = adminservice.loginAdmin(email, password);

	        if (adm != null) {
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