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

import com.diego.card.dto.SalaryDto;
import com.diego.card.entity.SalaryEntity;
import com.diego.card.service.SalaryService;
import com.diego.card.vo.ResponseVO;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	@GetMapping
	public ResponseEntity<ResponseVO<List<SalaryDto>>> findAll() {
		ResponseVO<List<SalaryDto>> response = new ResponseVO<>();
		try {
			response.setData(salaryService.findAll());
			response.setMessage("Ok");
			return new ResponseEntity<>(response,HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage("Error del servidor");
			return new ResponseEntity<>(response ,HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<ResponseVO<SalaryEntity>> create(@RequestBody SalaryDto salary) {
		ResponseVO<SalaryEntity> response = new ResponseVO<>();
		try {
			response.setMessage(salaryService.create(salary));
			return new ResponseEntity<>(response,HttpStatus.CREATED);
		} catch (Exception e) {
			response.setMessage("Error del servidor");
			return new ResponseEntity<>(response ,HttpStatus.OK);
		}
	}
}
