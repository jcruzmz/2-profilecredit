package com.diego.card.dto;

import java.util.List;

import com.diego.card.entity.CardEntity;

import lombok.Data;

@Data
public class ProfileCreditDto {
	private String id;
	private PassionDto passion;
	private SalaryDto salary;
	private AgeDto age;
	private List<CardEntity> cards;
}
