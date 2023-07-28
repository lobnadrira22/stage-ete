package com.example.projet.services;

import java.util.List;
import com.example.projet.entities.OffreEmploi;

public interface OffreEmploiService {
    OffreEmploi saveOffre(OffreEmploi offre);
    OffreEmploi updateOffre(OffreEmploi offre);
    void deleteOffre(OffreEmploi offre);
    void deleteOffreById(int id);
    OffreEmploi getOffre(int id);
    List<OffreEmploi> getAllOffres();
}

