package com.example.playlist.repository;

import com.example.playlist.model.Jogo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JogoRepository extends MongoRepository<Jogo, String> {
}