package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SalaoController {
	@Autowired
	private AdmServicoV2 se;
	@Autowired
	private AdmEscolhaV2 es;
	
	public SalaoController(AdmServicoV2 se, AdmEscolhaV2 es) {
		this.se = se;
		this.es = es;
	}
	                                           
	@GetMapping("/servicesio")
	public String consultarServicos(Model model) {
		model.addAttribute("servicos",se.findAll());
		System.out.println(se.findAll());
		return "services"; 
	}

	
	@PostMapping("/hello")
	public String hello(@RequestParam("servNome") String nameServ, @RequestParam("tempo") double tempo, @RequestParam("preco") double preco, Model model) {
		Servico s = new Servico(nameServ, tempo, preco);
		se.save(s);
		return "hello";
	}
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	
	
	}
	
	
}
