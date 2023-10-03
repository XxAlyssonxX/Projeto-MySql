package com.projetocontrole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetocontrole.entities.Ligacao;
import com.projetocontrole.service.LigacaoService;

@RestController 
@RequestMapping("/ligacao") 
public class LigacaoController { 

	private final LigacaoService ligacaoService; 

	@Autowired 
	public LigacaoController(LigacaoService ligacaoService) { 
		this.ligacaoService = ligacaoService; 
	} 

	@GetMapping("/{id}") 
	public ResponseEntity<Ligacao> buscaLigacaoControlId(@PathVariable Long id) { 
		Ligacao ligacao = ligacaoService.buscaLigacaoPeloCodigo(id); 
		if (ligacao != null) { 
			return ResponseEntity.ok(ligacao); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@GetMapping 
	public ResponseEntity<List<Ligacao>> buscaTodosLigacaoControl() { 
		List<Ligacao> ligacao = ligacaoService.buscaTodasLigacao(); 
		return ResponseEntity.ok(ligacao); 
	} 

	@PostMapping("/") 
	public ResponseEntity<Ligacao> salvaLigacaoControl(@RequestBody Ligacao ligacao) { 
		Ligacao salvaligacao = ligacaoService.salvaLigacao(ligacao); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaligacao); 
	} 

	@PutMapping("/{id}") 
	public ResponseEntity<Ligacao> alteraLigacaoControl(@PathVariable Long id, @RequestBody Ligacao ligacao) { 
		Ligacao alterarligacao = ligacaoService.alterarLigacao(ligacao, id); 
		if (alterarligacao != null) { 
			return ResponseEntity.ok(ligacao); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@DeleteMapping("/{codigo}") 
	public ResponseEntity<String> apagaLigacaoControl(@PathVariable Long id) { 
		boolean ligacao = ligacaoService.apagarLigacao(id); 
		if (ligacao) { 
			return ResponseEntity.ok().body("O ligacao foi excluído com sucesso"); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 
