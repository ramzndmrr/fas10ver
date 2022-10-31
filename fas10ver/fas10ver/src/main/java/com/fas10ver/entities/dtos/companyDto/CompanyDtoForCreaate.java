package com.fas10ver.entities.dtos.companyDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CompanyDtoForCreaate {

	@NotBlank
	@NotNull
	private String name;
	
	@NotBlank
	@NotNull
	private String address;
	
	@NotBlank
	@NotNull
	private String workType;
	
	@NotBlank
	@NotNull
	private String countries;
}
