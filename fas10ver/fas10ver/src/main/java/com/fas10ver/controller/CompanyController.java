package com.fas10ver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fas10ver.business.abstracts.CompanyService;
import com.fas10ver.entities.Company;
import com.fas10ver.entities.dtos.companyDto.CompanyDtoForCreaate;

@RestController
@RequestMapping("api/v1/companies")
@CrossOrigin
public class CompanyController {

	private CompanyService companyService;
	
	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		var response  = companyService.getAll();
		return ResponseEntity
				.status(response.getHttpStatus())
				.body(response);
	}
	 
	@GetMapping(path = "/{id}") 
	public ResponseEntity<?> getOneCompanyById(@PathVariable(name="id", required =true) int id){
		var response = companyService.getOneCompany(id);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody CompanyDtoForCreaate companyDtoForCreaate){
		var response = companyService.add(companyDtoForCreaate);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
}
