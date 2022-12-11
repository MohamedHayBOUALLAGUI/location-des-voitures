package com.tekup.location.services;

import java.util.List;

import com.tekup.location.model.Voiture;

public interface VoitureService {

	 List<Voiture> findAllVoitureByModeleId(Integer id);
}
