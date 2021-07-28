package com.diego.card.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diego.card.entity.AgeEntity;

@Repository
public interface AgeRepository extends MongoRepository<AgeEntity, String>{

}
