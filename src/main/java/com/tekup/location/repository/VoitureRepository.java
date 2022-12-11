package com.tekup.location.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.location.model.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Integer> {
	  List<Voiture> findAllByModeleId(Integer id);


}
