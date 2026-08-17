package com.example.playlist.service;

import com.example.playlist.model.Jogo;
import com.example.playlist.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    private final JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    public Jogo salvar(Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    public List<Jogo> listarTodos() {
        return jogoRepository.findAll();
    }

    public Optional<Jogo> buscarPorId(String id) {
        return jogoRepository.findById(id);
    }

    public Optional<Jogo> atualizar(String id, Jogo jogo) {

        return jogoRepository.findById(id)
                .map(jogoExistente -> {

                    jogoExistente.setNome(jogo.getNome());
                    jogoExistente.setDesenvolvedora(jogo.getDesenvolvedora());
                    jogoExistente.setGenero(jogo.getGenero());
                    jogoExistente.setAno(jogo.getAno());

                    return jogoRepository.save(jogoExistente);
                });
    }

    public void excluir(String id) {
        jogoRepository.deleteById(id);
    }
}