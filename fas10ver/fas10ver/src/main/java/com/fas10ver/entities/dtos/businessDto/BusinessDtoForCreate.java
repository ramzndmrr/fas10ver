package com.fas10ver.entities.dtos.businessDto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BusinessDtoForCreate {

	@NotNull
	@NotBlank
	private int companyId;
	
	@NotNull
	@NotBlank
	private String category;
	
	@NotNull
	@NotBlank
	private String type;

	@NotBlank
	@NotNull
	private String description;
	
	@NotNull
	@NotBlank
	private Date startDate;
	
	private Date endDate;
	
	
	@NotNull
	@NotBlank
	private int piece;
	
	@NotNull
	@NotBlank
	private Double contractPrice;
	
}
