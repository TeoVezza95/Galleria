package it.uniroma3.galleria.model;



import java.util.List;

import javax.persistence.*;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Stanza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String nome;
	
    private String url;
	@NotNull
	@Size(min=1)
	private String descrizione;

	
	@OneToMany(mappedBy="stanza", cascade=CascadeType.ALL)
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


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public List<Opera> getOpere() {
		return opere;
	}


	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}
}