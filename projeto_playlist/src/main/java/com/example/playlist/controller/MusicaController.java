package com.example.playlist.controller;

import com.example.playlist.model.Musica;
import com.example.playlist.service.MusicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private final MusicaService musicaService;

    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @PostMapping
    public Musica criar(@RequestBody Musica musica) {
        return musicaService.salvar(musica);
    }

    @GetMapping
    public List<Musica> listarTodas() {
        return musicaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> buscarPorId(@PathVariable String id) {

        return musicaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizar(
            @PathVariable String id,
            @RequestBody Musica musica) {

        return musicaService.atualizar(id, musica)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable String id) {

        musicaService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}