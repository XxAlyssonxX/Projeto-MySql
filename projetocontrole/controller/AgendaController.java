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

import com.projetocontrole.entities.Agenda;
import com.projetocontrole.service.AgendaService;

@RestController 
@RequestMapping("/agenda") 
public class AgendaController { 

	private final AgendaService agendaService; 

	@Autowired 
	public AgendaController(AgendaService agendaService) { 
		this.agendaService = agendaService; 
	} 

	@GetMapping("/{id}") 
	public ResponseEntity<Agenda> buscaAgendaControlId(@PathVariable Long id) { 
		Agenda agenda = agendaService.buscaAgendaPeloCodigo(id); 
		if (agenda != null) { 
			return ResponseEntity.ok(agenda); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@GetMapping 
	public ResponseEntity<List<Agenda>> buscaTodosAgendaControl() { 
		List<Agenda> agenda = agendaService.buscaTodasAgenda(); 
		return ResponseEntity.ok(agenda); 
	} 

	@PostMapping("/") 
	public ResponseEntity<Agenda> salvaAgendaControl(@RequestBody Agenda agenda) { 
		Agenda salvaAgenda = agendaService.salvaAgenda(agenda); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAgenda); 
	} 

	@PutMapping("/{id}") 
	public ResponseEntity<Agenda> alteraAgendaControl(@PathVariable Long id, @RequestBody Agenda agenda) { 
		Agenda alteraragenda = agendaService.alterarAgenda(agenda, id); 
		if (alteraragenda != null) { 
			return ResponseEntity.ok(agenda); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 

	@DeleteMapping("/{codigo}") 
	public ResponseEntity<String> apagaagendaControl(@PathVariable Long id) { 
		boolean agenda = agendaService.apagarAgenda(id); 
		if (agenda) { 
			return ResponseEntity.ok().body("O agenda foi excluído com sucesso"); 
		} else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
} 
