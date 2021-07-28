package com.diego.card.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.card.dto.SalaryDto;
import com.diego.card.entity.SalaryEntity;
import com.diego.card.repository.SalaryRepository;

@Service
public class SalaryService {
	
	@Autowired
	private SalaryRepository salaryRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	public List<SalaryDto> findAll(){
		List<SalaryEntity> listSalary = salaryRepository.findAll(); 
		return convertList(listSalary);
	}
	
	public String create(SalaryDto salary) {
		SalaryEntity salaryEntity = modelMapper.map(salary, SalaryEntity.class);
		salaryRepository.save(salaryEntity);
		return "Salario creado con éxito";
	}
	
	private List<SalaryDto> convertList(List<SalaryEntity> listSalary){
		List<SalaryDto> response = new ArrayList<>();
		listSalary.forEach(salary -> {
			SalaryDto salaryDto = modelMapper.map(salary, SalaryDto.class);
			response.add(salaryDto);
		});
		return response;
	}
}
