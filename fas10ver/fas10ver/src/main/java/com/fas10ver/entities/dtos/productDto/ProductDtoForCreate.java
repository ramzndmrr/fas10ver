package com.fas10ver.entities.dtos.productDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProductDtoForCreate {

	@NotBlank
	 @NotNull
	private String name;
	
	@NotBlank
	 @NotNull
	private String color;
	
	@NotBlank
	 @NotNull
	private int amount;
	
	@NotBlank
	@NotNull
	private int categoryId;
}
