package com.tekup.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.location.model.Client;



public interface ClientRepository extends JpaRepository<Client, Integer> {
	Client getClientByName(String nom);
}
