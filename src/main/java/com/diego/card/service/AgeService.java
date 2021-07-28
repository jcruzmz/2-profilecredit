package com.diego.card.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.card.dto.AgeDto;
import com.diego.card.entity.AgeEntity;
import com.diego.card.repository.AgeRepository;

@Service
public class AgeService {
	@Autowired
	private AgeRepository ageRepository;
	
	@Autowired
    private ModelMapper modelMapper;

	public List<AgeDto> findAll() {
		List<AgeEntity> listAge = ageRepository.findAll(); 
		return convertList(listAge);
	}

	public String create(AgeDto age) {
		AgeEntity ageEntity = modelMapper.map(age, AgeEntity.class);
		ageRepository.save(ageEntity);
		return "Edad creada";
	}
	
	private List<AgeDto> convertList(List<AgeEntity> listCard){
		List<AgeDto> response = new ArrayList<>();
		listCard.forEach(age -> {
			AgeDto ageDto = modelMapper.map(age, AgeDto.class);
			response.add(ageDto);
		});
		return response;
	}
}
