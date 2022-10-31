package com.fas10ver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fas10ver.business.abstracts.EmployeeService;
import com.fas10ver.entities.dtos.employeDto.EmployeeDtoForCreate;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@PostMapping()
	public ResponseEntity<?> add(@RequestBody EmployeeDtoForCreate create){
		var response = employeeService.add(create);
		return ResponseEntity
				.status(response.getHttpStatus())
				.body(response);
	}
	
	@GetMapping
	public ResponseEntity<?> getall(){
		var response = employeeService.getAll();
		return ResponseEntity
				.status(response.getHttpStatus())
				.body(response);
	}
	

}
