package com.fas10ver.exceptions;

public class BusinessNotFoundException  extends NotFoundException{
	
	public BusinessNotFoundException(int id) {
		super(String.format("Business with %s id could not found", id));
		
	}
}
