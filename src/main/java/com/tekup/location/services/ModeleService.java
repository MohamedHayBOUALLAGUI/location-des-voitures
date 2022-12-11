package com.tekup.location.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.location.exception.EntityNotFoundException;
import com.tekup.location.exception.InvalidOperationException;
import com.tekup.location.model.Modele;
import com.tekup.location.model.Voiture;
import com.tekup.location.repository.ModeleRepository;
import com.tekup.location.repository.VoitureRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class ModeleService {
	
	
	private ModeleRepository modeleRepository;
	private VoitureRepository voitureRepository;
	
	  @Autowired
	  public ModeleService(ModeleRepository modeleRepository, VoitureRepository voitureRepository) {
	    this.modeleRepository = modeleRepository;
	    this.voitureRepository = voitureRepository;
	  }
	
	//Liste des modèles
	public List<Modele> listModel(){
		
		return modeleRepository.findAll();
	}
	
	//Ajouter un model
	public void saveModel(Modele model) {
		
		modeleRepository.save(model);
	}
	
	//Récupérer un model par un id
	public Modele getmodel(Integer id) throws Exception {
		
		if (id == null) {
		      log.error("Modele ID is null");
		      return null;
		    }
		Modele modele=modeleRepository.findById(id).get();
		if(modele == null) {
			throw new EntityNotFoundException(
		            "Aucun modéle avec l'ID = " + id + " n' ete trouve dans la BDD");
		}
		
			return modele;
		
	}
	
	//Supprimer un model par un id
	public void deleteModel(Integer id) throws Exception {
	    if (id == null) {
	        log.error("Model ID is null");
	        return;
	      }
	    List<Voiture> voitures = voitureRepository.findAllByModeleId(id);
	    if (!voitures.isEmpty()) {
	      throw new InvalidOperationException("Impossible de supprimer ce modele qui est deja utilise");
	    }
		modeleRepository.deleteById(id);
	}

}
