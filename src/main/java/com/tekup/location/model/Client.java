package com.tekup.location.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Client extends AbstractEntity{

	
	@Column(name="cin")
    private Integer cin;
     
    @Column(name="nom")
    private String nom;
     
    @Column(name="prenom")
    private String prenom;

    @Column(name="adresse")
    private String adresse;
    
    @OneToMany(mappedBy = "client")
    private List<Location> locations;
}
