package it.uniroma3.galleria.model;
import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min=1)
	private String email ;
	
	@NotNull
	@Size(min=8)
	private String password;
	
	@NotNull
	@Size(min=1)
	private String nome;
	
	@NotNull
	@Size(min=1)
	private String cognome;
	
	public Utente(){}
	
	public Utente( String email){
		this.email = email;
	}
	
	public Utente(String email, String password, String nome, String cognome){
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@Override
	public String toString() {
		return "Utente [id=" + id + ", email=" + email + ", password=" + password + ", nome=" + nome + ", cognome=" + cognome + "]";
	}

}

