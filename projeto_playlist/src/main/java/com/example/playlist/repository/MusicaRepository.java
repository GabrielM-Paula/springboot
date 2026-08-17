package com.example.playlist.repository;

import com.example.playlist.model.Musica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicaRepository extends MongoRepository<Musica, String> {

}