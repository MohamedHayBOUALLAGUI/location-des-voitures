package com.tekup.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tekup.location.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	
	  // JPQL query
	  @Query(value = "select u from User u where u.username = :username")
	  //Optional<Utilisateur> findUtilisateurByEmail(@Param("username") String username);	  
	  User findByUsername(@Param("username")String username);
	  
	  
	  
}







