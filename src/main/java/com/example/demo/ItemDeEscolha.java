package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ItemDeEscolha")
public class ItemDeEscolha {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch=FetchType.EAGER)
	private Servico servico;
	
	public int getId() {
		return id;
	}
	public Servico getServico() {
		return servico;
	}
	public void setProduto(Servico servico) {
		this.servico = servico;
	}
	public double getSubTotal() {
		return servico.getPreco();
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
}

