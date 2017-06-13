package it.uniroma3.galleria.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Autore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@Size(min=1)
	@Temporal(TemporalType.DATE)
	private Date annoNascita;

	@NotNull
	@Size(min=1)
	@Temporal(TemporalType.DATE)
	private Date annoMorte;

	@NotNull
	@OneToMany(mappedBy="autore", cascade=CascadeType.ALL)
	private List<Opera> opere;
	

    protected Autore() {}
	
	public Autore(String nome, String cognome,String nazionalita, Date annoNascita, Date annoMorte) {
		this.nome = nome;
		this.cognome = cognome;
		this.nazionalita = nazionalita;
		this.annoNascita= annoNascita;
		this.annoMorte = annoMorte;
		
	}
	

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
	public void setOpere(List<Opera> quadri) {
		this.opere = quadri;
	}
	
	@Override
	public String toString() {
		return "Autore [id =" + id + ", nome =" + nome + ", cognome=" + cognome + ", nazionalita=" + nazionalita + 
				", annoNascita =" + annoNascita + ", annoMorte ="  + annoMorte +"]";
	}
	

}
