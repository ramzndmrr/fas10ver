package com.fas10ver.entities.dtos.brandDto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

 @Data
public class BrandDtoForUpdate {

	@NotBlank(message= " name cannot be blank")
	 @NotNull(message= " name cannot be null")
	 @Size(min=3, message = "name must contains at least 3 char")
	private String name;
	
	 @NotNull
	private List<Integer> machineIds;
	 
	 
}
