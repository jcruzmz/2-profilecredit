package com.diego.card.entity;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "profilecredit")
public class ProfileCreditEntity {
	@Id
	private String id;
	@DBRef
	private PassionEntity passion;
	@DBRef
	private SalaryEntity salary;
	@DBRef
	private AgeEntity age;
	@DBRef
	private List<CardEntity> cards;
}
