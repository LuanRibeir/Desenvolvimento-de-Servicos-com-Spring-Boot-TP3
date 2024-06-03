package com.luanribeiro.tp3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luanribeiro.tp3.model.MaterialDidatico;

@Repository
public interface MaterialDidaticoRepository extends MongoRepository<MaterialDidatico, String> {

}