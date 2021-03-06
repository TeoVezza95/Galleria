package it.uniroma3.galleria.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.galleria.model.Autore;
import it.uniroma3.galleria.service.AutoreService;
import it.uniroma3.galleria.service.OperaService;

@Controller
public class AutoreController {
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	} 


	@Autowired
	AutoreService autoreService;
	OperaService operaService;
	@GetMapping("/autori")
	public String showAutori(Model model){
		List<Autore> autori = (List<Autore>) autoreService.findAll();
		model.addAttribute("autori", autori);
		return "autore/autori";
	}
	
	@GetMapping("/autoriAdmin")
	public String showAutoriAdmin(Model model){
		List<Autore> autori = (List<Autore>) autoreService.findAll();
		model.addAttribute("autori", autori);
		return "autore/autoriAdmin";
	}

	@GetMapping("/autore")
	public String showForm(Autore autore) {
		return "autore/formAutore";
	}
	@GetMapping("/autore/resultsAutore")
	public String showAutore(@RequestParam("id")long id, Model model){
		Autore a = autoreService.findbyId(id);
		model.addAttribute("autore", a);
		return "autore/resultsAutore";
	}

	@GetMapping("/autore/resultsAutoreUtente")
	public String showAutorePerUtente(@RequestParam("id")long id, Model model){
		Autore a = autoreService.findbyId(id);
		model.addAttribute("autore", a);
		return "autore/resultsAutoreUtente";
	}


	@GetMapping("autore/cancella")
	public ModelAndView deleteAutore(@RequestParam("id")long id, Model model){
		autoreService.delete(id);
		return new ModelAndView("redirect:/autori");
	}
	

	@PostMapping("/autore")
	public String checkCustomerInfo(@Valid @ModelAttribute Autore autore, 
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "autore/formAutore";
		} else {
			model.addAttribute(autore);
			autoreService.addAutore(autore); 
		}
		return "autore/resultsAutore";
	}
	@GetMapping("/autore/modificaAutore")
	public String modificaAutore(Model model,@RequestParam("id")Long id) {

		Autore autore=autoreService.findbyId(id);
		model.addAttribute("autore",autore);
		return "autore/modificaAutore";
	}

	@PostMapping("/autore/modificaAutore")
	public String modificaAutor(@Valid @ModelAttribute Autore autore, 
			BindingResult bindingResult, Model model ){
		if (bindingResult.hasErrors()) {
			return "autore/modificaAutore";
		}
		else {
			model.addAttribute(autore);
			try{
				autoreService.addAutore(autore);
			}catch(Exception e){
				return"autore/modificaAutore";

			}
		}
		return "autore/resultsAutore";
	}
}
