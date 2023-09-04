package com.example.projet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projet.entities.Calendrier;
import com.example.projet.entities.Employeur;
import com.example.projet.services.CalendrierService;
import com.example.projet.services.EmployeurService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/calendriers")
public class CalendrierController {
	@Autowired
	private CalendrierService calendrierserv;
	@Autowired
	private EmployeurService employeurService;
	
	
	
	 @PostMapping
	    public Calendrier createCalendrier(@RequestBody Calendrier calendrier) {
		  
		    

		    return calendrierserv.saveCalendrier(calendrier);
	    }
	 @GetMapping("/{id}")
	    public Calendrier getCalendrier(@PathVariable int id) {
	        return calendrierserv.getCalendrier(id);
	    }

	    @GetMapping
	    public List<Calendrier> getAllCalendriers() {
	        return calendrierserv.getAllCalendriers();
	    }

	    @PutMapping("/{id}")
	    public Calendrier updateCalendrier(@PathVariable int id, @RequestBody Calendrier calendrier) {
	        calendrier.setId(id);
	        return calendrierserv.updateCalendrier(calendrier);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCalendrier(@PathVariable int id) {
	    	calendrierserv.deleteCalendrierById(id);
	    }

}
