package com.tekup.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tekup.location.model.Client;




public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	  // JPQL query
	  @Query(value = "select c from Client c where c.nom = :nom")
	  Client getClientByName(@Param("nom")String nom);
	  //Optional<Utilisateur> findUtilisateurByEmail(@Param("username") String username);
	  
	  //User findByUsername(@Param("username")String username);
}
