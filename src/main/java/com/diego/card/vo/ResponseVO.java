package com.diego.card.vo;

import lombok.Data;

@Data
public class ResponseVO <T>{
	private String message;
	private T data;
}
