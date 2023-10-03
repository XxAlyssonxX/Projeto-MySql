package com.projetocontrole.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetocontrole.entities.Ligacao;
import com.projetocontrole.repository.LigacaoRepository;

@Service
public class LigacaoService {
	private final LigacaoRepository ligacaoRepository; 

	@Autowired 
	public LigacaoService(LigacaoRepository ligacaoRepository) { 
		this.ligacaoRepository = ligacaoRepository; 
	} 

	public List<Ligacao> buscaTodasLigacao() { 
		return ligacaoRepository.findAll(); 
	} 

	public Ligacao buscaLigacaoPeloCodigo(Long id) { 
		Optional<Ligacao> ligacao = ligacaoRepository.findById(id); 
		return ligacao.orElse(null); 
	} 

	public Ligacao salvaLigacao(Ligacao ligacao) { 
		return ligacaoRepository.save(ligacao); 
	} 

	public Ligacao alterarLigacao(Ligacao alterarLigacao, Long id) { 
		Optional<Ligacao> existeLigacao = ligacaoRepository.findById(id); 
		if (existeLigacao.isPresent()) { 
			alterarLigacao.setId(id); 
			return ligacaoRepository.save(alterarLigacao); 
		} 
		return null; 
	} 

	public boolean apagarLigacao(Long id) { 
		Optional<Ligacao> existeLigacao = ligacaoRepository.findById(id); 
		if (existeLigacao.isPresent()) { 
			ligacaoRepository.deleteById(id); 
			return true; 
		} 
		return false; 
	} 
}
