package com.fas10ver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fas10ver.business.abstracts.MachineService;
import com.fas10ver.entities.dtos.machineDto.MachineDtoForCreate;
import com.fas10ver.entities.models.ApiResponse;

@RestController
@RequestMapping("api/v1/machines")
public class MachineController {

	private MachineService machineService;

	
	public MachineController(MachineService machineService) {
		this.machineService = machineService;
	}
	
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody MachineDtoForCreate create){
		var response = machineService.add(create);
		
		return ResponseEntity
				.status(response.getHttpStatus())
				.body(response);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		var response = machineService.getAll();
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	

}
