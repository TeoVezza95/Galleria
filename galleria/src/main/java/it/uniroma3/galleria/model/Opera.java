package it.uniroma3.galleria.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Opera implements Comparable<Opera> {

protected Opera() {}
	
	public Opera(String nome, String descrizione,String tecnica, Integer anno,String dim, Autore autore, Stanza stanza, String url,double lunghezza,double larghezza) {
		this.nome = nome;
		this.url=url;
		this.descrizione = descrizione;
		this.tecnica = tecnica;
		this.anno = anno;
		this.dimensione= dim;
		this.autore =autore;
		this.stanza=stanza;
	}
	private String url;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String nome;

	@NotNull
	@Size(min=1)
	private String descrizione;
	

	@NotNull
	@Size(min=1)
	private String tecnica;
	

	@NotNull
	@Size(min=1)
	private String dimensione;

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public String getDimensione() {
		return dimensione;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}
	@NotNull
	@Min(1)
	private Integer anno;
	
	@ManyToOne
	private Stanza stanza;
	
	@ManyToOne
	private Autore autore;

	
	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public Stanza getStanza() {
		return stanza;
	}

	public void setStanza(Stanza stanza) {
		this.stanza = stanza;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	@Override
	public String toString() {
		return String.format(
				"Opera[id=%d, nome='%s', descrizione='%s', anno=%d]",
				id, nome, descrizione, anno);
	}
	@Override
	public int compareTo(Opera that) {
		return this.nome.toUpperCase().compareTo(that.nome.toUpperCase());
	}
}