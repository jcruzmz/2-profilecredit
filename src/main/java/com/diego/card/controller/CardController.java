package com.diego.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.card.dto.CardDto;
import com.diego.card.service.CardService;
import com.diego.card.vo.ResponseVO;

@RestController
@RequestMapping("/api/cards")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@GetMapping()
	public ResponseEntity<ResponseVO<List<CardDto>>> findAll(){
		ResponseVO<List<CardDto>> response = new ResponseVO<>();
		try {
			response.setData(cardService.findAll());
			response.setMessage("Ok");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage("Error del servidor");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping()
	public ResponseEntity<ResponseVO<CardDto>> create(@RequestBody CardDto card){
		ResponseVO<CardDto> response = new ResponseVO<>();
		try {
			response.setMessage(cardService.create(card));
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			response.setMessage("Error del servidor");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
