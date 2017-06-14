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
import it.uniroma3.galleria.service.AutoreService;
import it.uniroma3.galleria.service.OperaService;

@Controller
public class OperaController  {
	@Autowired
	private AutoreService autoreService;
	@Autowired
	private OperaService operaService; 

	@GetMapping("/opera")
	public String showForm(Model model, Opera opera){
		List<Autore> autori = (List<Autore>) autoreService.findAll();
		model.addAttribute("autori", autori);
		return "opera/formOpera";
	}
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
	@PostMapping("/opera")
	public String checkCustomerInfo(@Valid @ModelAttribute Opera opera, 
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "opera/formOpera";
		}
		else {
		
			model.addAttribute(opera);
			operaService.add(opera); 
		}
		return "opera/resultsOpera";
	}
}

