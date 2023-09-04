package com.example.projet.services;

import java.util.List;

import com.example.projet.entities.Calendrier;

public interface CalendrierService {
	Calendrier saveCalendrier(Calendrier calendar);
	Calendrier updateCalendrier(Calendrier calendar);
	    void deleteCalendrier(Calendrier calendar);
	    void deleteCalendrierById(int id);
	    Calendrier getCalendrier(int id);
	    List<Calendrier> getAllCalendriers();

}
