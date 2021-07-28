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

import com.diego.card.dto.AgeDto;
import com.diego.card.service.AgeService;
import com.diego.card.vo.ResponseVO;

@RestController
@RequestMapping("/api/age")
public class AgeController {
	@Autowired
	private AgeService ageService;
	
	@GetMapping()
	public ResponseEntity<ResponseVO<List<AgeDto>>> findAll(){
		ResponseVO<List<AgeDto>> response = new ResponseVO<>();
		try {
			response.setData(ageService.findAll());
			response.setMessage("Ok");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage("Error interno del servidor");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping()
	public ResponseEntity<ResponseVO<AgeDto>> create(@RequestBody AgeDto card){
		ResponseVO<AgeDto> response = new ResponseVO<>();
		try {
			response.setMessage(ageService.create(card));
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			response.setMessage("Error interno del servidor");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
