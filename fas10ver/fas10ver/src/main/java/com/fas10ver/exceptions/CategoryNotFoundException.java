package com.fas10ver.exceptions;

public class CategoryNotFoundException extends NotFoundException {
	public CategoryNotFoundException(int id) {
		super(String.format("Category with %s id could not found", id));
		
	}
}
