package it.uniroma3.galleria.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.galleria.model.Stanza;

import it.uniroma3.galleria.service.StanzaService;

@Controller
public class StanzaController {
	
		
	
	@Autowired
	StanzaService stanzaService;
	
	@GetMapping("/stanze")
	public String showstanze(Model model){
		List<Stanza> stanze = (List<Stanza>) stanzaService.findAll();
		model.addAttribute("stanze", stanze);
		return "stanza/stanze";
	}
	@GetMapping("/stanzeAdmin")
	public String showstanzeadmin(Model model){
		List<Stanza> stanze = (List<Stanza>) stanzaService.findAll();
		model.addAttribute("stanze", stanze);
		return "stanza/stanzeAdmin";
	}
	
    @GetMapping("/stanza")
    public String showForm(Stanza stanza) {
        return "stanza/formstanza";
    }
    @GetMapping("/stanza/resultsStanza")
	public String showStanza(@RequestParam("id")long id, Model model){
		Stanza s = stanzaService.findbyId(id);
		model.addAttribute("stanza", s);
		return "stanza/resultsStanza";
	}
    
    @GetMapping("stanza/cancella")
	public ModelAndView deleteStanza(@RequestParam("id")long id, Model model){
		stanzaService.delete(id);
		return new ModelAndView("redirect:/stanze");
	}
    
    
    
    @PostMapping("/stanza")
    public String checkCustomerInfo(@Valid @ModelAttribute Stanza stanza, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "stanza/formStanza";
        } else {
        	model.addAttribute(stanza);
        	stanzaService.addStanza(stanza); 
        }
        return "stanza/resultsStanza";
    }
    @GetMapping("/stanza/modificaStanza")
	public String modificaStanza(Model model,@RequestParam("id")Long id) {

		Stanza stanza=stanzaService.findbyId(id);
		model.addAttribute("stanza",stanza);
		return "stanza/modificaStanza";
	}

	@PostMapping("/stanza/modificaStanza")
	public String modificastanza(@Valid @ModelAttribute Stanza stanza, 
			BindingResult bindingResult, Model model ){
		if (bindingResult.hasErrors()) {
			return "stanza/modificaStanza";
		}
		else {
			model.addAttribute(stanza);
			try{
				stanzaService.addStanza(stanza);
			}catch(Exception e){
				return"stanza/modificaStanza";

			}
		}
		return "stanza/resultsStanza";
	}
}
