package it.uniroma3.galleria.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@Entity
public class Autore {
	private String url;
public Autore() {}
	
	public Autore(String nome, String nazionalita, Date annoNascita, Date annoMorte,String url) {
		this.nome = nome;
		this.nazionalita = nazionalita;
		this.annoNascita = annoNascita;
		this.opere = new LinkedList<>();
		this.annoMorte=annoMorte;
		this.url=url;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String nome;

	@NotNull
	@Size(min=1)
	private String cognome;

	@NotNull
	@Size(min=1)
	private String nazionalita;

	@NotNull
	@Past
    @Temporal(TemporalType.DATE)
	private Date annoNascita;

	
	
	@Temporal(TemporalType.DATE)
	private Date annoMorte;

	@OneToMany(mappedBy="autore", cascade=CascadeType.ALL)
	private List<Opera> opere;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNazionalita() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	public Date getAnnoNascita() {
		return annoNascita;
	}
	public void setAnnoNascita(Date annoNascita) {
		this.annoNascita = annoNascita;
	}
	public Date getAnnoMorte() {
		return annoMorte;
	}
	public void setAnnoMorte(Date annoMorte) {
		this.annoMorte = annoMorte;
	}


	public List<Opera> getOpere() {
		return opere;
	}
	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}

	@Override
	public String toString() {
		return "Autore [id =" + id + ", nome =" + nome + ", cognome=" + cognome + ", nazionalita=" + nazionalita + 
				", annoNascita =" + annoNascita + ", annoMorte ="  + annoMorte +"]";
	}


}
