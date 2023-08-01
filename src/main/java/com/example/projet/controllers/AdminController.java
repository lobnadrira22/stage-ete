package com.example.projet.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.projet.entities.Admin;
import com.example.projet.entities.Employeur;
import com.example.projet.services.AdminService;
import com.example.projet.services.EmployeurService;
import java.util.List;
import java.util.Map;

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

	        // Mettre à jour les champs spécifiés dans le corps de la requête (dans le Map "updates")
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

}