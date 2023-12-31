package com.example.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.entities.OffreEmploi;
import com.example.projet.repos.OffreEmploiRepository;
@Service
public class OffreEmploiServiceImpl implements OffreEmploiService{
	@Autowired
	OffreEmploiRepository offrerep;
	  @Autowired
	    EmployeurService employeurService; 
	@Override
    public OffreEmploi saveOffre(OffreEmploi offre) {
    
        if (offre.getEmployeur() != null) {
            // Vérifiez si l'employeur existe dans la base de données
            int employeurId = offre.getEmployeur().getIdEmployeur();
            if (employeurService.getEmployee(employeurId) == null) {
               
                employeurService.saveEmployee(offre.getEmployeur());
            }
        }
        return offrerep.save(offre);
    }

	 @Override
	    public OffreEmploi updateOffre(OffreEmploi offre) {
	    
	        if (offre.getEmployeur() != null) {
	            int employeurId = offre.getEmployeur().getIdEmployeur();
	            if (employeurService.getEmployee(employeurId) == null) {
	                employeurService.saveEmployee(offre.getEmployeur());
	            }
	        }
	        return offrerep.save(offre);
	    }

	@Override
	public void deleteOffre(OffreEmploi offre) {
		offrerep.delete(offre);
		
	}

	@Override
	public void deleteOffreById(int id) {
		offrerep.deleteById(id);		
	}
	@Override
	public OffreEmploi getOffre(int id) {
	    return offrerep.findById(id).get();
	}


	@Override
	public List<OffreEmploi> getAllOffres() {
		return offrerep.findAll();
	}

}
