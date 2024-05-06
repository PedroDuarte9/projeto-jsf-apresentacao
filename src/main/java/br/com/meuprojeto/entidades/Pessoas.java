package br.com.meuprojeto.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pessoas_Cadastro")
public class Pessoas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	private long numeroTelefone;
	private String email;
	
	
	public Pessoas() {
	}


	public Pessoas(String nome, long numeroTelefone, String email) {
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public long getNumeroTelefone() {
		return numeroTelefone;
	}


	public void setNumeroTelefone(long numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getId() {
		return Id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(Id, email, nome, numeroTelefone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoas other = (Pessoas) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& numeroTelefone == other.numeroTelefone;
	}

	
}
