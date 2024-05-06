package br.com.meuprojeto.contoller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.meuprojeto.dao.DaoGeneric;
import br.com.meuprojeto.entidades.Pessoas;

@ManagedBean(name = "pessoasControl")
@SessionScoped
public class PessoasBean {
	
	private Pessoas pessoa = new Pessoas();
	List<Pessoas> listaPessoas = new ArrayList<>();
	private DaoGeneric<Pessoas> daoGeneric = new DaoGeneric<Pessoas>();	
	private boolean cadastroRealizado = false;
	private String mensagem = "";
	
	public Pessoas getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoas pessoa) {
		this.pessoa = pessoa;
	}

	public DaoGeneric<Pessoas> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Pessoas> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Pessoas> getListaPessoas() {
		return listaPessoas;
	}
	
	
	public boolean isCadastroRealizado() {
		return cadastroRealizado;
	}

	public void setCadastroRealizado(boolean cadastroRealizado) {
		this.cadastroRealizado = cadastroRealizado;
	}
	
	

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void salvar() {
		daoGeneric.salvar(pessoa);
		pessoa = new Pessoas();
		setCadastroRealizado(true);
		setMensagem("Cadastrado com sucesso !");
		System.out.println("Cadastrado");
	}
	
	public void remover() {
		daoGeneric.remover(pessoa);
	}

	public void listarTodos() {
		listaPessoas.add(pessoa);
		
		for(Pessoas p : listaPessoas) {
			System.out.println(p);
		}
	}
}
