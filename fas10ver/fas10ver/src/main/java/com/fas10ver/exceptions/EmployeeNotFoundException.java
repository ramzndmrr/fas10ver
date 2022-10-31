package com.fas10ver.exceptions;

public class EmployeeNotFoundException extends NotFoundException {
	public EmployeeNotFoundException(int id) {
		super(String.format("Employee with %s id could not found", id));
		
	}


}
