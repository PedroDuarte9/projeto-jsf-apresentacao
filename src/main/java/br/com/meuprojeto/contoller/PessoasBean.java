package br.com.meuprojeto.contoller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.meuprojeto.entidades.Pessoas;

@ManagedBean(name = "pessoasControl")
@SessionScoped
public class PessoasBean {
	
	Pessoas pessoa = new Pessoas();
	List<Pessoas> listaPessoas = new ArrayList<>();
	
	public void listarTodos() {
		listaPessoas.add(pessoa);
		
		for(Pessoas p : listaPessoas) {
			System.out.println(p);
		}
	}
}
