package com.fas10ver.entities.dtos.machineDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MachineDtoForCreate {
	

	private int age;
	private String type;
	private int brandId;

}
