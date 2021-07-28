package com.diego.card.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diego.card.entity.CardEntity;

@Repository
public interface CardRepository extends MongoRepository<CardEntity, String>{

}
