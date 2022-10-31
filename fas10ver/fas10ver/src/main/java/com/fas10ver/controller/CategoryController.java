package com.fas10ver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fas10ver.business.abstracts.CategoryService;
import com.fas10ver.entities.dtos.categoryDto.CategoryDtoForCreate;

@RestController
@RequestMapping("api/v1/categories")
@CrossOrigin
public class CategoryController {

	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody CategoryDtoForCreate create){
		var response = categoryService.add(create);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		var response = categoryService.getAll();
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}

	@GetMapping(path = "/{id}") 
	public ResponseEntity<?> getOneCategory(@PathVariable(name="id", required =true) int id){
		var response = categoryService.getOneCategory(id);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}

}
