  package br.com.meuprojeto.contoller;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.meuprojeto.dao.DaoGeneric;
import br.com.meuprojeto.entidades.Pessoa;



@SessionScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {
	
	private Pessoa pessoa = new Pessoa();
	List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();


	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public DaoGeneric<Pessoa> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Pessoa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}
	
	@PostConstruct
	public void init() {
		carregarPessoas();
	}
	
	public void salvar() {
	pessoa = daoGeneric.atualizar(pessoa);
	carregarPessoas();
		
	}
	
	public void novo() {
		pessoa = new Pessoa();
	}
	
	
	public void remover() {
		daoGeneric.removerPorId(pessoa);
		carregarPessoas();
	}
	
	public void carregarPessoas() {
		listaPessoas = daoGeneric.listaBanco(Pessoa.class);
	}
	
	public void editarPessoas() {
		pessoa = daoGeneric.atualizar(pessoa);
	}
}
