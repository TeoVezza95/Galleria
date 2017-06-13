package it.uniroma3.galleria.model;




import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "admin")
public class Amministratore{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "admin")
	private String nome;

	@NotNull
	@Size(min=8)
	@Column(name = "password")
	private String password;


	public Amministratore(){}

	public Amministratore(String nome, String password) {
		this.nome = nome;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Amministratore [id=" + id + ", nome=" + nome + ", password=" + password + "]";
	}
}
