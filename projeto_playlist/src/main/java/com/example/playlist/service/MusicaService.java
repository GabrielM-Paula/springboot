package com.example.playlist.service;

import com.example.playlist.model.Musica;
import com.example.playlist.repository.MusicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {

    private final MusicaRepository musicaRepository;

    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    public Musica salvar(Musica musica) {
        return musicaRepository.save(musica);
    }

    public List<Musica> listarTodas() {
        return musicaRepository.findAll();
    }

    public Optional<Musica> buscarPorId(String id) {
        return musicaRepository.findById(id);
    }

    public Optional<Musica> atualizar(String id, Musica musica) {

        return musicaRepository.findById(id)
                .map(musicaExistente -> {

                    musicaExistente.setNome(musica.getNome());
                    musicaExistente.setArtista(musica.getArtista());
                    musicaExistente.setAlbum(musica.getAlbum());
                    musicaExistente.setAno(musica.getAno());

                    return musicaRepository.save(musicaExistente);
                });
    }

    public void excluir(String id) {
        musicaRepository.deleteById(id);
    }
}