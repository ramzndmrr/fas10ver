package com.fas10ver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fas10ver.business.abstracts.BrandService;
import com.fas10ver.entities.Brand;
import com.fas10ver.entities.dtos.brandDto.BrandDtoForCreate;



@RestController
@RequestMapping("api/v1/brands")
public class BrandController {
	
	private BrandService brandService;
	
	
	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}



	@GetMapping
	public ResponseEntity<?> getAllBrand(){
		var response = brandService.getAllBrand();
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}

	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody BrandDtoForCreate brand){
			var response = brandService.add(brand);
			return ResponseEntity
					.status(response.getHttpStatus())
					.body(response);
	}
	
	@GetMapping(path = "/{id}") 
	public ResponseEntity<?> getOneBrand(@PathVariable(name = "id", required = true) int id){
		var response = brandService.getOneBrand(id);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	

}
