package it.uniroma3.galleria.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import it.uniroma3.galleria.model.Stanza;
import it.uniroma3.galleria.repository.StanzaRepository;


@Service
public class StanzaService {

	@Autowired
	private StanzaRepository stanzaRepository; 

	@Transactional
	public void addStanza(final Stanza stanza) {
		this.stanzaRepository.save(stanza);
	}
	
	@Transactional
	public void delete(Long id){
		this.stanzaRepository.delete(id);
	}
	@Transactional
	public void removeStanza(Stanza stanza){
		this.stanzaRepository.delete(stanza);
	}
	
	public Iterable<Stanza> findAll() {
		return this.stanzaRepository.findAll();
	}
	public Stanza findbyId(Long id) {
		return this.stanzaRepository.findOne(id);
	}
	
	public Iterable<Stanza>findByNome(String nome) {
		return this.stanzaRepository.findByNome(nome);
	}
}