package com.tekup.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tekup.location.model.Modele;
import com.tekup.location.services.ModeleService;

@Controller
public class ModeleController {
	
	
	@Autowired
	private ModeleService modelService;
	
	//Ajouter un model 
	
	//1- Retourner un forumlaire d'ajout
	
	@RequestMapping("/addModel")
	public String addModel(Model model) {
		
		Modele modele = new Modele();
		model.addAttribute("modele", modele);
		return "new_modele";
	}
	
	//2- Ajout + redirection vers la liste des modeles
	
	@PostMapping(value="/saveModel")
	public String saveModel(@ModelAttribute("modele") Modele model) {
		//modelService.saveModel(model);
		modelService.saveModel(model);
		return "redirect:/listeModel";
	}
	
	//Liste des modeles
	
	@RequestMapping("/listeModel")
	public String listModel(Model model) {
	    List<Modele> listModel = modelService.listModel();
	    model.addAttribute("listModeles", listModel);
	     
	    return "liste_modeles";
	}
	
	/*@GetMapping("editModel/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Modele modele = modelService.getmodel(id);
        model.addAttribute("model", modele);
        return "update_model";
    }

    @PostMapping("updateModel/{id}")
    public String updateModel(@PathVariable("id") long id,
    		@Valid Modele modele, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            modele.setId(id);
            return "update_model";
        }

        modelService.saveModel(modele);
        model.addAttribute("listModeles", modelService.listModel());
        return "redirect:/listeModel";
    }

    @GetMapping("deleteModel/{id}")
    public String deleteModel(@PathVariable("id") long id, Model model) {
     
    modelService.deleteModel(id);
        model.addAttribute("listeModel", modelService.listModel());
        return "redirect:/listeModel";
    }*/

}
