package com.tekup.location.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Location extends AbstractEntity {
	
	//Une opération de location de voiture possède une date de début, une date de fin, type de 
	//garantie, frais de location, (espèce ou chèque), montant de garantie, etc
	 	
		@Column(name="date_debut")
	    private Date dateDebut;
	    
	    @Column(name="date_retour")
	    private Date dateRetour;
	    

	    
	    @Column(name="prix")
	    private Double  prix;
	    
	    @ManyToOne
	    @JoinColumn(name="client_id")
	    private Client client; 
	    
	    @ManyToOne
	    @JoinColumn(name="voiture_id")
	    private Voiture voiture;

}
