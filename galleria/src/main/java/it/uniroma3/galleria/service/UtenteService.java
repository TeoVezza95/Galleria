package it.uniroma3.galleria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Utente;
import it.uniroma3.galleria.repository.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteRepository utenteRepository;
	
    @Transactional
    public void add(final Utente utente) {
        this.utenteRepository.save(utente);
    }
    
    public Utente findById(Long id){
    	return this.utenteRepository.findOne(id);
    }
}
