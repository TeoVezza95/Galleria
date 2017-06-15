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

import it.uniroma3.galleria.model.Autore;
import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.model.Stanza;
import it.uniroma3.galleria.service.AutoreService;
import it.uniroma3.galleria.service.OperaService;
import it.uniroma3.galleria.service.StanzaService;

@Controller
public class OperaController  {
	@Autowired
	private StanzaService stanzaService;
	@Autowired
	private AutoreService autoreService;
	@Autowired
	private OperaService operaService; 

	

	@GetMapping("/opere")
	public String showAutori(Model model){
		List<Opera> opere = (List<Opera>) operaService.findAll();
		model.addAttribute("opere", opere);
		return "opera/opere";
	}
	
	@GetMapping("opera/cancella")
	public ModelAndView deleteAutore(@RequestParam("id")long id, Model model){
		operaService.delete(id);
		return new ModelAndView("redirect:/opere");
	}
	@GetMapping("/opera/resultsOpera")
	public String showAutore(@RequestParam("id")long id, Model model){
		Opera o = operaService.findbyId(id);
		model.addAttribute("opera", o); 
		return "opera/resultsOpera";
	}

	
	
	@GetMapping("/opera")
	public String showForm(Model model, Opera opera){
		List<Autore> autori = (List<Autore>) autoreService.findAll();
		List<Stanza>stanze= (List<Stanza>) stanzaService.findAll();
		model.addAttribute("autori", autori);
		model.addAttribute("stanze",stanze);
		return "opera/formOpera";
	}
	
	@PostMapping("/opera")
	public String checkCustomerInfo(@Valid @ModelAttribute Opera opera, 
			BindingResult bindingResult, Model model) {
		List<Autore> autori = (List<Autore>) autoreService.findAll();
		List<Stanza>stanze= (List<Stanza>) stanzaService.findAll();
		model.addAttribute("autori", autori);
		model.addAttribute("stanze",stanze);
		if (bindingResult.hasErrors()) {
			return "opera/formOpera";
		}
		else {

			model.addAttribute(opera);
			operaService.save(opera); 
		}
		return "opera/resultsOpera";
	}
	@GetMapping("opera/modificaOpera")
	public String checkCustomerInfo(Model model,@RequestParam("id")long id) {
		List<Autore> autori = (List<Autore>) autoreService.findAll();
		List<Stanza>stanze= (List<Stanza>) stanzaService.findAll();
		model.addAttribute("autori", autori);
		model.addAttribute("stanze",stanze);
		Opera opera=operaService.findbyId(id);
		model.addAttribute("opera",opera);
		return "opera/modificaOpera";
	}
	
	@PostMapping("opera/modificaOpera")
	public String checkCustomer(@Valid @ModelAttribute Opera opera, 
			BindingResult bindingResult, Model model ){
		List<Autore> autori = (List<Autore>) autoreService.findAll();
		List<Stanza>stanze= (List<Stanza>) stanzaService.findAll();
		model.addAttribute("autori", autori);
		model.addAttribute("stanze",stanze);
		if (bindingResult.hasErrors()) {
			return "opera/modificaOpera";
		}
		else {
         
			model.addAttribute(opera);
			operaService.save(opera);
		}
		return "opera/resultsOpera";
	}
	

}

