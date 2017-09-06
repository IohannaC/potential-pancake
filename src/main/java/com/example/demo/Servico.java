package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Servicos")
public class Servico {
	@Id
	private int id;
	private double tempo;
	private double preco;
	private String servNome;
	
	public Servico () {
		
	}
	
	public Servico(int id, double tempo, double preco, String servNome) {
		this.id = id;
		this.tempo = tempo;
		this.preco = preco;
		this.servNome = servNome;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public String getServNome() {
		return servNome;
	}
	
	public void mudaPreco (double preco) {
		this.preco = preco;
	}
	
	
	
}
