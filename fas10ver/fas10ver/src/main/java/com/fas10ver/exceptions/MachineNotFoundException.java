package com.fas10ver.exceptions;

public class MachineNotFoundException extends NotFoundException{
	
	public MachineNotFoundException(int id) {
		super(String.format("Machine with %s id could not found", id));
		
	}

}
