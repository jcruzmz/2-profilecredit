package com.diego.card.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.card.dto.CardDto;
import com.diego.card.entity.CardEntity;
import com.diego.card.repository.CardRepository;

@Service
public class CardService {

	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private CardRepository cardRepository;
	
	public List<CardDto> findAll(){
		List<CardEntity> listCard = cardRepository.findAll(); 
		return convertList(listCard);
	}
	
	public String create(CardDto card) {
		CardEntity request = modelMapper.map(card, CardEntity.class);
		cardRepository.save(request);
		return "Tarjeta creada";
	}
	
	private List<CardDto> convertList(List<CardEntity> listCard){
		List<CardDto> response = new ArrayList<>();
		listCard.forEach(card -> {
			CardDto cardDto = modelMapper.map(card, CardDto.class);
			response.add(cardDto);
		});
		return response;
	}
}
