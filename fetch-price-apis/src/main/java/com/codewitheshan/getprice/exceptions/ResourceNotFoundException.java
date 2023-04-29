package com.codewitheshan.getprice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	String price;
	String message;

	public ResourceNotFoundException(String price, String message) {
		super(String.format("price is %s beacuse %s", price, message));
		this.price = price;
		this.message = message;
	}
}
