package com.fas10ver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fas10ver.business.abstracts.BusinessService;
import com.fas10ver.entities.dtos.businessDto.BusinessDtoForCreate;

@CrossOrigin
@RestController
@RequestMapping("api/v1/businesses")
public class BusinessController {
	
	private BusinessService businessService;

	@Autowired
	public BusinessController(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		var response = businessService.getAll();
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getOneBusiness(@PathVariable(name = "id", required = true) int id){
		var response = businessService.getOneBusiness(id);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody  BusinessDtoForCreate businessDtoForCreate){
		var response = businessService.add(businessDtoForCreate);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
	

}
