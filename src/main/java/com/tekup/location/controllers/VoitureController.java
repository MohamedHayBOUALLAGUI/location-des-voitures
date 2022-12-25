package com.tekup.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tekup.location.model.Modele;
import com.tekup.location.model.Voiture;
import com.tekup.location.services.ModeleService;
import com.tekup.location.services.VoitureService;


@Controller

public class VoitureController {
	
	
	@Autowired
	private VoitureService voitureService;
	
	@Autowired
	private ModeleService modelService;
	

	
	//private VoitureServiceImpl voitureService;
	//private ModeleService modelService;
	
	/*@Autowired
	public VoitureController(VoitureServiceImpl voitureService,ModeleService modelService) {
		this.modelService=modelService;
		this.voitureService=voitureService;
	}*/
	
	//Ajouter une voiture 
	
	//1- Retourner un forumlaire d'ajout
	
	@GetMapping("/addVoiture")
	public String addVoiture(Model model) {
		
		Voiture voiture = new Voiture();
		List<Modele> listModel = modelService.listModel();
		
		model.addAttribute("VoitureForm", voiture);
		model.addAttribute("modelList", listModel);
		return "new_voiture";
	}
	
	//2- Ajout + redirection vers la liste des voitures
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveVoiture(@ModelAttribute("VoitureForm") Voiture voiture) {
		voitureService.saveVoiture(voiture);
	
		return "redirect:/";
	}
	
	//Liste des voitures
	
	@RequestMapping("/")
	public String listVoitures(Model model) {
	    List<Voiture> listVoitures = voitureService.listVoiture();
	    model.addAttribute("listVoitures", listVoitures);
	     
	    return "liste_voitures";
	}
	
	@GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) throws Exception {
        Voiture voiture = voitureService.getVoiture(id);
        model.addAttribute("voiture", voiture);
        //Modele modele=voiture.getModel();
        //model.addAttribute("modele",modele);
        
      List<Modele> listModel = modelService.listModel();
      	model.addAttribute("modelList", listModel);
      	
        return "update_voiture";
    }

    @PostMapping("update/{id}")
    public String updateVoiture(@PathVariable("id") Integer id, @ModelAttribute("voiture") Voiture voitureForm, Model model
    		) throws Exception {
 
    	
    	Voiture voiture= voitureService.getVoiture(id);
    	
    	
    	voiture.setId(voitureForm.getId());
    	voiture.setImmatriculation(voitureForm.getImmatriculation());
    	voiture.setDateMiseEnCirculation(voitureForm.getDateMiseEnCirculation());
    	voiture.setModel(voitureForm.getModel());
    	
    	
    	voiture.setPrixJour(voitureForm.getPrixJour());
    	
    	

        voitureService.saveVoiture(voiture);
        model.addAttribute("listVoitures", voitureService.listVoiture());
        return "redirect:/";
    }
   
    
    
    
    
    
    
    
    
    
    
    
    //-----------------------------------------------------------------------

    @GetMapping("delete/{id}")
    public String deleteVoiture(@PathVariable("id") Integer id, Model model) {
     
    	voitureService.deleteVoiture(id);
        model.addAttribute("listVoitures", voitureService.listVoiture());
        return "redirect:/";
    }

}
