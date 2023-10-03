package com.projetocontrole.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetocontrole.entities.Agenda;
import com.projetocontrole.repository.AgendaRepository;

@Service
public class AgendaService {
	private final AgendaRepository agendaRepository; 

	@Autowired 
	public AgendaService(AgendaRepository agendaRepository) { 
		this.agendaRepository = agendaRepository; 
	} 

	public List<Agenda> buscaTodasAgenda() { 
		return agendaRepository.findAll(); 
	} 

	public Agenda buscaAgendaPeloCodigo(Long id) { 
		Optional<Agenda> agenda = agendaRepository.findById(id); 
		return agenda.orElse(null); 
	} 

	public Agenda salvaAgenda(Agenda agenda) { 
		return agendaRepository.save(agenda); 
	} 

	public Agenda alterarAgenda(Agenda alterarAgenda, Long id) { 
		Optional<Agenda> existeAgenda = agendaRepository.findById(id); 
		if (existeAgenda.isPresent()) { 
			alterarAgenda.setId(id); 
			return agendaRepository.save(alterarAgenda); 
		} 
		return null; 
	} 

	public boolean apagarAgenda(Long id) { 
		Optional<Agenda> existeAgenda = agendaRepository.findById(id); 
		if (existeAgenda.isPresent()) { 
			agendaRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 
}
