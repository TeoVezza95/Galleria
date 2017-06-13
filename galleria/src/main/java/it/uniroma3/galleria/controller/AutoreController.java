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
	
	@GetMapping("/autori")
	public String showAutori(Model model){
		List<Autore> autori = (List<Autore>) autoreService.findAll();
		model.addAttribute("autori", autori);
		return "autori";
	}
	
    @GetMapping("/autore")
    public String showForm(Autore autore) {
        return "formAutore";
    }
    @GetMapping("/autore/resultsAutore")
	public String showAutore(@RequestParam("id")long id, Model model){
		Autore a = autoreService.findbyId(id);
		model.addAttribute("autore", a);
		return "autore/resultsAutore";
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
            return "formAutore";
        } else {
        	model.addAttribute(autore);
        	autoreService.addAutore(autore); 
        }
        return "autore/resultsAutore";
    }

}
