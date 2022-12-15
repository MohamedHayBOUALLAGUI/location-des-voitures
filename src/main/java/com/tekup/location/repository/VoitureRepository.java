package com.tekup.location.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tekup.location.model.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Integer> {
	
	@Query("select v from Voiture v, Modele m where v.model.id = :id")
	 List<Voiture> findAllByModeleId(@Param("id") Integer id);


}
