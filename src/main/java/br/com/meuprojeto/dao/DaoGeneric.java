package br.com.meuprojeto.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.meuprojeto.entidades.Employee;
import br.com.meuprojeto.jpautil.JPAUtil;

public class DaoGeneric<T>{
	
	public void salvar(T entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(entidade);
		
		entityTransaction.commit();
		entityManager.close();	
		System.out.println("Salvou");
		
	}
	
	public void remover(T entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(entidade);
		
		entityTransaction.commit();
		entityManager.close();
		System.out.println("Deletado");
	}
	
	public void removerPorId(T entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Object id = JPAUtil.getEntidadePorId(entidade);
		Query query = entityManager.createQuery("delete from " + entidade.getClass().getCanonicalName() + " where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		entityTransaction.commit();
		entityManager.close();
		System.out.println("Removido");
	}
	
	
	public T atualizar(T entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		T retorno = entityManager.merge(entidade);
		
		entityTransaction.commit();
		entityManager.close();
		
		return retorno;
	}
	
	public List<T> listaBanco(Class <T> entidade) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<T> listaRetorno = entityManager.createQuery("from " + entidade.getName()).getResultList();
			
		entityTransaction.commit();
		entityManager.close();
		
		return listaRetorno;
	}
	
	
	

}
