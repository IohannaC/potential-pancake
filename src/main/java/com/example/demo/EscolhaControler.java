package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;



@Controller
public class EscolhaControler {
	private AdmServicoV2 se;
	private AdmEscolhaV2 es;
	
	@Autowired
	public EscolhaControler(AdmServicoV2 se, AdmEscolhaV2 es) {
		this.se = se;
		this.es = es;
	}
	
	@GetMapping("/escolhas)")
	public Iterable<Escolha> consultarVendas() {
		return es.findAll();
	}
	
	@GetMapping("/servicos)")
	public String seila() {
		return "redirect:/servicos";
	}
	
	@GetMapping("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ")
	public ResponseEntity<Escolha> consultarEscolha(@PathVariable("id") int id) {
		Escolha e = es.findOne(id);
		if(e != null)
			return new ResponseEntity<>(e, HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/escolhas")
	public ResponseEntity<Void> adicionarEscolhas(@RequestBody Escolha escolha, UriComponentsBuilder uc) {
		if(escolha.getId()!=0 && es.exists(escolha.getId())) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		Escolha novaEscolha = es.save(escolha);
		HttpHeaders cabecalho = new HttpHeaders();
		cabecalho.setLocation(uc.path("/escolhas/{id}").buildAndExpand(novaEscolha.getId()).toUri());
		return new ResponseEntity<Void>(cabecalho, HttpStatus.CREATED);
	}
	
	@PutMapping("/escolhas/{codEscolha}/{codServico}")
	public ResponseEntity<Escolha> adicionarServicoEscolha(@PathVariable("codEscolha") int codEscolha, @PathVariable("codServico") int codServico) {
		Escolha e = es.findOne(codEscolha);
		if(e != null) {
			Servico s = se.findOne(codServico);
			if (s != null) {
				e.escolher(s);
				es.save(e);
				return new ResponseEntity<Escolha>(e, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
}
