package it.uniroma3.galleria.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import it.uniroma3.galleria.model.Autore;
import it.uniroma3.galleria.repository.AutoreRepository;

@Service
public class AutoreService {

	@Autowired
	private AutoreRepository autoreRepository; 

	@Transactional
	public void addAutore(final Autore autore) {
		this.autoreRepository.save(autore);
	}
	
	@Transactional
	public void delete(Long id){
		this.autoreRepository.delete(id);
	}
	@Transactional
	public void removeAutore(Autore autore){
		this.autoreRepository.delete(autore);
	}
	
	public Iterable<Autore> findAll() {
		return this.autoreRepository.findAll();
	}
	public Autore findbyId(Long id) {
		return this.autoreRepository.findOne(id);
	}
	
	public Iterable<Autore>findByNome(String titolo) {
		return this.autoreRepository.findByNome(titolo);
	}
	
	public Iterable<Autore>findByCognome(String cognome) {
		return this.autoreRepository.findByCognome(cognome);
	}
	
	public Iterable<Autore>findByNazionalita(String nazionalita) {
		return this.autoreRepository.findByNazionalita(nazionalita);
	}
	
	public Iterable<Autore>findByAnnoNascita(Date anno) {
		return this.autoreRepository.findByAnnoNascita(anno);
	}
	
	public Iterable<Autore>findByAnnoMorte(Date anno) {
		return this.autoreRepository.findByAnnoMorte(anno);
	}

}