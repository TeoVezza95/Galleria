package it.uniroma3.galleria.repository;




import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.galleria.model.Stanza;



public interface StanzaRepository extends CrudRepository<Stanza, Long> {

	List<Stanza> findAll();
	
    List<Stanza> findByNome(String nome);
    
    List<Stanza> findByDescrizione(String descrizione);
    
 
}
