package com.diego.card.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.card.dto.PassionDto;
import com.diego.card.entity.PassionEntity;
import com.diego.card.repository.PassionRepository;

@Service
public class PassionService {
	
	@Autowired
	private PassionRepository passionRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	public List<PassionDto> findAll(){
		List<PassionEntity> listPassion = passionRepository.findAll(); 
		return convertList(listPassion);
	}
	
	public PassionDto findByName(String name){
		PassionDto passion = null;
		try {
			passion= modelMapper.map(passionRepository.findByName(name), PassionDto.class);
			return passion;
		} catch (Exception e) {
			return passion;
		}
	}
	
	public String create(PassionDto passion) {
		PassionEntity passionEntity = modelMapper.map(passion, PassionEntity.class);
		passionRepository.save(passionEntity);
		return "Pasion creada con éxito";
	}
	
	private List<PassionDto> convertList(List<PassionEntity> listCard){
		List<PassionDto> response = new ArrayList<>();
		listCard.forEach(passion -> {
			PassionDto passionDto = modelMapper.map(passion, PassionDto.class);
			response.add(passionDto);
		});
		return response;
	}
}
