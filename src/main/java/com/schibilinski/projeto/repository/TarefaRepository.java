package com.schibilinski.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schibilinski.projeto.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {



}
