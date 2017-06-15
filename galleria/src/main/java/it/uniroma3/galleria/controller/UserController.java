package it.uniroma3.galleria.controller;




import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.galleria.model.User;

import it.uniroma3.galleria.service.UserService;

@Controller
public class UserController {
	
		
	
	@Autowired
	UserService userService;
	
	
	
    @GetMapping("/user")
    public String showForm(User utente) {
        return "user/formUtente";
    }
    @GetMapping("/user/resultsUtente")
	public String showUtente(@RequestParam("id")long id, Model model){
    	User u = userService.findById(id);
		model.addAttribute("user", u);
		return "user/resultsUtente";
	}
   
    
    @PostMapping("/user")
    public String checkCustomerInfo(@Valid @ModelAttribute User user, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "user/formUtente";
        } else {
        	model.addAttribute(user);
        	userService.add(user); 
        }
        return "user/resultsUtente";
    }

}
