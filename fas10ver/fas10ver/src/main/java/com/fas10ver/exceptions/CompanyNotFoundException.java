package com.fas10ver.exceptions;

public class CompanyNotFoundException extends NotFoundException {
	
	public CompanyNotFoundException(int id) {
		super(String.format("Compnay with %s id could not found", id));
		
	}

}
