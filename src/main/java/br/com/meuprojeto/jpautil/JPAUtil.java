package br.com.meuprojeto.jpautil;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = null; 
	
	static {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("meu-primeiro-projeto");
		}
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static Object getEntidadePorId(Object entidade) {
	
		return factory.getPersistenceUnitUtil().getIdentifier(entidade);
	}
	
	
	
}
