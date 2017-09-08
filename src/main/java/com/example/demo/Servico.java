package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicos")
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idserv")
	private int id;
	@Column(name = "tempo")
	private double tempo;
	@Column(name = "preco")
	private double preco;
	@Column(name = "nomeserv")
	private String servNome;
	
	public Servico () {
		
	}
	
	public Servico(String servNome ,double tempo, double preco) {
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

	@Override
	public String toString() {
		return "Servico [id=" + id + ", tempo=" + tempo + ", preco=" + preco + ", servNome=" + servNome + "]";
	}
	
	
	
}
