package com.diego.card.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diego.card.entity.SalaryEntity;

@Repository
public interface SalaryRepository extends MongoRepository<SalaryEntity, String>{

}
