package com.fas10ver.exceptions;

public class BrandNotFoundException extends NotFoundException{

	public BrandNotFoundException(int id) {
		super(String.format("Brand with %s id could not found", id));
		
	}

	 
}
