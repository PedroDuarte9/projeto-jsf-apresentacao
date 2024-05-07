package br.com.meuprojeto.contoller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.meuprojeto.dao.DaoGeneric;
import br.com.meuprojeto.entidades.Pessoas;


@ViewScoped
@ManagedBean(name = "pessoasControl")
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
		pessoa = daoGeneric.atualizar(pessoa);
		
		setCadastroRealizado(true);
		//setMensagem("Cadastrado com sucesso !");
		//System.out.println("Cadastrado");
	}

	
	public void atualizar() {
		pessoa = daoGeneric.atualizar(pessoa);
	}

	@PostConstruct
	public void listarTodos() {
		listaPessoas = daoGeneric.listaBanco(Pessoas.class);
	}
	
	public void novo() {
		pessoa = new Pessoas();
	}
	public void remover() {
		daoGeneric.removerPorId(pessoa);
	}
	public void removerLinha() {
		daoGeneric.remover(pessoa);
	}
	

    public void editarLinha(Pessoas pessoaSelecionada) {
        this.pessoa = pessoaSelecionada;
        // Aqui você pode adicionar qualquer lógica adicional necessária para editar a linha
    }
}
