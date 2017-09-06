package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class Controller {
	private AdmServicoV2 se;
	private AdmEscolhaV2 es;
	
	@Autowired
	public Controller(AdmServicoV2 se, AdmEscolhaV2 es) {
		this.se = se;
		this.es = es;
	}
	                                           
	@GetMapping("/show-services")
	public String consultarServicos(Model model) {
		model.addAttribute("name",se.findAll());
		System.out.println(se.findAll());
		return "show-services"; 
	}
	@GetMapping("/showCarrinho")
	public String mostrarCarrinho(Model model) {
		model.addAttribute("lista", se.findAll());
		return "show-carrinho";
	}
}
