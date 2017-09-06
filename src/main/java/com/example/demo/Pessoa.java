package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Pessoa")
public class Pessoa {
	@Id
	private int id;
	private String nome;
	private String user;
	private int senha;
	private int phone;
	
	public Pessoa(String nome, String user, int senha, int phone) {
		this.nome = nome;
		this.user = user;
		this.senha = senha;
		this.phone = phone;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
}
