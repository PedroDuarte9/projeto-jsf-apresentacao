package br.com.meuprojeto;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


@SessionScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {
	
	private String nome;
	private String sobrenome;
	private String nomeCompleto;
	
	public String juntarNomes() {
		nomeCompleto = nome + " " + sobrenome;
		return nomeCompleto;
	}
	
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
		
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
		

	
}
