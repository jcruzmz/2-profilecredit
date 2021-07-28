package com.diego.card.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.card.dto.PassionDto;
import com.diego.card.dto.ProfileCreditDto;
import com.diego.card.service.PassionService;
import com.diego.card.service.ProfileCreditService;
import com.diego.card.vo.RequestVO;
import com.diego.card.vo.ResponseVO;

@RestController
@RequestMapping("/api/profile")
public class ProfileCreditController {

	@Autowired
	private ProfileCreditService profileCreditService;

	@Autowired
	private PassionService passionService;

	@GetMapping()
	public ResponseEntity<ResponseVO<List<ProfileCreditDto>>> findAll() {
		ResponseVO<List<ProfileCreditDto>> response = new ResponseVO<>();
		try {
			response.setMessage("Ok");
			response.setData(profileCreditService.findAll());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage("Error del sevidor profile");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping()
	public ResponseEntity<ResponseVO<ProfileCreditDto>> create(@RequestBody ProfileCreditDto profile) {
		ResponseVO<ProfileCreditDto> response = new ResponseVO<>();
		try {
			response.setMessage(profileCreditService.create(profile));
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			response.setMessage("Error del sevidor");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/credit")
	public ResponseEntity<ResponseVO<List<ProfileCreditDto>>> findProfileCredit(@RequestBody RequestVO request) {
		ResponseVO<List<ProfileCreditDto>> response = new ResponseVO<>();
		try {
			PassionDto passionDto = passionService.findByName(request.getPassion());
			if (!Objects.isNull(passionDto)) {
				List<ProfileCreditDto> listProfiles = profileCreditService.findByPassion(passionDto).stream()
						.filter(profile -> request.getAge() >= profile.getAge().getLowerAge() && request.getAge() <= profile.getAge().getHigherAge())
						.filter(profile2 -> request.getSalary() >= profile2.getSalary().getLowerSalary() && request.getSalary() <= profile2.getSalary().getHigherSalary())
						.collect(Collectors.toList());
				response.setMessage("Lista de tarjetas encontrada acorde al perfil");
				response.setData(listProfiles);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response.setMessage("Preferencia no encontrada");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
