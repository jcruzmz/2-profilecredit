package com.diego.card.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diego.card.entity.PassionEntity;

@Repository
public interface PassionRepository extends MongoRepository<PassionEntity, String> {
	public PassionEntity findByName(String name);

}
