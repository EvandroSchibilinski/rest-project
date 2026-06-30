package com.schibilinski.projeto.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schibilinski.projeto.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    public List<Tarefa> findByTituloContainingIgnoreCase(String titulo);

    public List<Tarefa> findByDataLimiteBefore(LocalDate now);

    public List<Tarefa> findByStatus(Tarefa.StatusTarefa status);

}
