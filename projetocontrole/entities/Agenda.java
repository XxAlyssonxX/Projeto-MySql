package com.projetocontrole.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity  
@Table(name = "Agenda") 
public class Agenda { 

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	
	@NotNull(message = "nome é obrigatório")
	@NotBlank(message = "nome é obrigatório")
	@Column(name = "nome") 
	private String nome; 

	@NotNull(message = "ddd é obrigatório")
	@NotBlank(message = "ddd é obrigatório")
	@Column(name = "ddd") 
	private String ddd; 
	
	@NotNull(message = "telefone é obrigatório")
	@NotBlank(message = "telefone é obrigatório")
	@Column(name = "telefone") 
	private String telefone;
	
	public Long getId() { 
		return id; 
	} 

	public void setId(Long id) { 
		this.id = id; 
	} 

	public String getNome() { 
		return nome; 
	} 

	public void setNome(String nome) { 
		this.nome = nome; 
	} 

	public String getDdd() { 
		return ddd; 
	}

	public void setDdd(String ddd) { 
		this.ddd = ddd; 
	} 

	public String getTelefone() { 
		return telefone; 
	} 

	public void setTelefone(String telefone) { 
		this.telefone = telefone; 
	} 

}