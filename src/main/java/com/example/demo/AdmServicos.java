package com.example.demo;

import java.util.List;

public interface AdmServicos {
	
	void addServicos (Servico s);
//	String getServicos (String servNome);
//	void setPreco (double preco);
//	void atualizaTempo (int id, double tempo);

	Servico consultarPorId(int id);
	List<Servico> consultarTudo();
}
