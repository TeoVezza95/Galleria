package it.uniroma3.galleria.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.galleria.model.Utente;

public interface UtenteRepository  extends CrudRepository<Utente,Long>{

	List<Utente>findByNome(String nome);
	List<Utente>findByCognome(String cognome) ;
	List<Utente>findByEmail(String email) ;
	List<Utente>findByPassword(String password) ;
	List<Utente>findAll() ;


}
