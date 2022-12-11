package com.tekup.location.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.location.exception.EntityNotFoundException;

import com.tekup.location.model.Voiture;
import com.tekup.location.repository.VoitureRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VoitureServiceImpl implements VoitureService {
	
	private VoitureRepository voitureRepository;
	
	@Autowired
	public VoitureServiceImpl(VoitureRepository voitureRepository) {
		this.voitureRepository=voitureRepository;
	}
	
	//Liste des voitures
		public List<Voiture> listVoiture(){
			
			return voitureRepository.findAll();
		}
		
		//Ajouter une voiture
		public void saveVoiture(Voiture voiture) {
			
			voitureRepository.save(voiture);
		}
		
		//Récuperer une voiture par un id
		public Voiture getVoiture(Integer id) throws Exception{
			
			if (id == null) {
			      log.error("Voiture ID is null");
			      return null;
			    }
			Voiture voiture=voitureRepository.findById(id).get();
			if(voiture == null) {
				throw new EntityNotFoundException(
			            "Aucune voiture avec l'ID = " + id + " n' ete trouve dans la BDD");
			}
			
				return voiture;
		}
		
		//Supprimer une voiture par un id
		public void deleteVoiture(Integer id) {
		    if (id == null) {
		        log.error("Voiture ID is null");
		        return;
		      }
			voitureRepository.deleteById(id);
		}
		
		//Supprimer 
			public void deleteAll() {
				if(!listVoiture().isEmpty())
				voitureRepository.deleteAll();
			}


	
	  @Override
	  public List<Voiture> findAllVoitureByModeleId(Integer id) {
	    return voitureRepository.findAllByModeleId(id).stream()
	        .collect(Collectors.toList());
	  }

	
	
	
}
