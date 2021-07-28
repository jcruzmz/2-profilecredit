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

import com.diego.card.dto.PassionDto;
import com.diego.card.service.PassionService;
import com.diego.card.vo.ResponseVO;

@RestController
@RequestMapping("/api/passion")
public class PassionController {

	@Autowired
	private PassionService passionService;

	@GetMapping
	public ResponseEntity<ResponseVO<List<PassionDto>>> findAll() {
		ResponseVO<List<PassionDto>> response = new ResponseVO<>();
		try {
			response.setData(passionService.findAll());
			response.setMessage("Ok");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage("Error interno del servidor");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<ResponseVO<PassionDto>> create(@RequestBody PassionDto passion) {
		ResponseVO<PassionDto> response = new ResponseVO<>();
		try {
			response.setMessage(passionService.create(passion));
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			response.setMessage("Error interno del servidor");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
}
