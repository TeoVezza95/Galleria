package it.uniroma3.galleria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.galleria.model.Autore;
import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.service.AutoreService;

@Controller
public class AutoreController {
	@Autowired
	AutoreService autoreService;
	
    @GetMapping("/autore")
    public String showForm(Opera opera) {
        return "form";
    }

    @PostMapping("/autore")
    public String checkCustomerInfo(@Valid @ModelAttribute Autore autore, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "form";
        } else {
        	model.addAttribute(autore);
        	autoreService.addAutore(autore); 
        }
        return "results";
    }

}
