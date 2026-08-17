package com.example.playlist.controller;

import com.example.playlist.model.Jogo;
import com.example.playlist.service.JogoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @PostMapping
    public Jogo criar(@RequestBody Jogo jogo) {
        return jogoService.salvar(jogo);
    }

    @GetMapping
    public List<Jogo> listarTodos() {
        return jogoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarPorId(@PathVariable String id) {

        return jogoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizar(
            @PathVariable String id,
            @RequestBody Jogo jogo) {

        return jogoService.atualizar(id, jogo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable String id) {

        jogoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}