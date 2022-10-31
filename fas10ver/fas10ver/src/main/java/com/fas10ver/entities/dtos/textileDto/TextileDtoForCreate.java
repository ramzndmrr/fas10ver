package com.fas10ver.entities.dtos.textileDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TextileDtoForCreate {

	
	@NotBlank
	@NotNull
	private String name;
	
	@NotBlank
	@NotNull
	private String address;
	
	
}
