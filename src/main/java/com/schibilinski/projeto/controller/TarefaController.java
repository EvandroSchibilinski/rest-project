package com.schibilinski.projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Tarefa")

public class TarefaController {
    @GetMapping("/{id}")
    public String BuscarId(@PathVariable String id) {
        return "id";
    }



}
