package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public class AdmServicosJPA implements AdmServicos{
	@PersistenceContext
	private EntityManager em;

	public void addServicos(Servico s) {
		em.persist(s);
		
	}

//	public String getServicos(String servNome) {
//		return null;
		
//	}

//	public void setPreco( double preco) {
//	}
	
//	public void atualizaTempo(int id, double tempo) {
		
		
//	}
	
	public Servico consultarPorId(int id) {
		return em.find(Servico.class, id);
	}
	
	
	public List<Servico> consultarTudo() {
		return em.createQuery("select p from Produto p", Servico.class).getResultList();
		
	}
		
	

}
