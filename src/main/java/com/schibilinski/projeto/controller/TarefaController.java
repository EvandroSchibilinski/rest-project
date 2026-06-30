package com.schibilinski.projeto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schibilinski.projeto.entity.Tarefa;
import com.schibilinski.projeto.entity.Tarefa.StatusTarefa;
import com.schibilinski.projeto.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.criar(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTodas() {
        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.buscarPorId(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Tarefa>> listarPorStatus(@PathVariable StatusTarefa status) {
        return ResponseEntity.ok(tarefaService.listarPorStatus(status));
    }

    @GetMapping("/atrasadas")
    public ResponseEntity<List<Tarefa>> listarAtrasadas() {
        return ResponseEntity.ok(tarefaService.listarAtrasadas());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Tarefa>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(tarefaService.buscarPorTitulo(titulo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return ResponseEntity.ok(tarefaService.atualizar(id, tarefa));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Tarefa> atualizarStatus(
            @PathVariable Long id,
            @RequestParam StatusTarefa status) {
        return ResponseEntity.ok(tarefaService.atualizarStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        tarefaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
