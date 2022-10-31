package com.fas10ver.exceptions;

public class OfferNotFoundException extends NotFoundException {

	public OfferNotFoundException(int id) {
		super(String.format("Offer with %s id could not found", id));
		
	}

}
