package com.diego.card.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.card.dto.PassionDto;
import com.diego.card.dto.ProfileCreditDto;
import com.diego.card.entity.PassionEntity;
import com.diego.card.entity.ProfileCreditEntity;
import com.diego.card.repository.ProfileCreditRepository;

@Service
public class ProfileCreditService {
	
	@Autowired
	private ProfileCreditRepository profileCreditRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	public List<ProfileCreditDto> findAll() {
		List<ProfileCreditEntity> listProfile = profileCreditRepository.findAll(); 
		return convertList(listProfile);
	}
	
	public List<ProfileCreditDto> findByPassion(PassionDto passion) {
		PassionEntity passionEntity = modelMapper.map(passion, PassionEntity.class);
		List<ProfileCreditEntity> listProfile = profileCreditRepository.findByPassion(passionEntity); 
		return convertList(listProfile);
	}
	
	public String create(ProfileCreditDto profile) {
		ProfileCreditEntity profileEntity = modelMapper.map(profile, ProfileCreditEntity.class);
		profileCreditRepository.insert(profileEntity);
		return "Perfil creado con éxito";
	}
	
	private List<ProfileCreditDto> convertList(List<ProfileCreditEntity> listProfile){
		List<ProfileCreditDto> response = new ArrayList<>();
		listProfile.forEach(profile -> {
			ProfileCreditDto profileDto = modelMapper.map(profile, ProfileCreditDto.class);
			response.add(profileDto);
		});
		return response;
	}
}
