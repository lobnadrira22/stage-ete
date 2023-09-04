package com.example.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.entities.Calendrier;
import com.example.projet.repos.CalendrierRepository;

@Service
public class CalendrierServiceImpl implements CalendrierService {
	 @Autowired
	    private CalendrierRepository calendrierRepository;
	@Override
	public Calendrier saveCalendrier(Calendrier calendar) {
		return calendrierRepository.save(calendar);
	}

	@Override
	public Calendrier updateCalendrier(Calendrier calendar) {
		return calendrierRepository.save(calendar);
	}

	@Override
	public void deleteCalendrier(Calendrier calendar) {
		calendrierRepository.delete(calendar);
		
	}

	@Override
	public void deleteCalendrierById(int id) {
		calendrierRepository.deleteById(id);
		
	}

	@Override
	public Calendrier getCalendrier(int id) {
		  return calendrierRepository.findById(id).orElse(null);
	}

	@Override
	public List<Calendrier> getAllCalendriers() {
		return calendrierRepository.findAll();
	}

}
