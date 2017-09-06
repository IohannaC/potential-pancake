package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Escolhas")
public class Escolha {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToMany(fetch= FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	private List<ItemDeEscolha> servicoEscolhidos;
	
	public int getId() {
		return id;
	}
	public List<ItemDeEscolha> getServicoEscolhidos() {
		return servicoEscolhidos;
	}
	
	public void escolher(Servico serv) {
		ItemDeEscolha item = new ItemDeEscolha();
		item.setServico(serv);
		servicoEscolhidos.add(item);
	}
}
