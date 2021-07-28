package com.diego.card.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diego.card.entity.PassionEntity;
import com.diego.card.entity.ProfileCreditEntity;

@Repository
public interface ProfileCreditRepository extends MongoRepository<ProfileCreditEntity, String>{
	
	public List<ProfileCreditEntity> findByPassion(PassionEntity passion);
}
