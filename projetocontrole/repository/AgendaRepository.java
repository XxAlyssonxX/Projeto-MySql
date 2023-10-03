package com.projetocontrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetocontrole.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
