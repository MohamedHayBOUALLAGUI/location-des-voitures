package com.tekup.location.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity

public class Voiture extends AbstractEntity {
	
	
	//Une voiture est caractérisée par son immatriculation, sa marque, sa date de mise en circulation
	//et son prix de location
	
	@Column(name = "immatriculation")
	private String immatriculation;
	
	
    @Column(name="date_mise_en_circulation")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateMiseEnCirculation;
    
    @Column(name="prix_jour")
    private Double prixJour;
    
    @ManyToOne
    @JoinColumn(name="model_id")
    private Modele model;

    @OneToMany(mappedBy = "voiture")
    private List<Location> locations;

}
