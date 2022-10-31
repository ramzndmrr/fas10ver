package com.fas10ver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fas10ver.business.abstracts.ProductService;
import com.fas10ver.entities.dtos.productDto.ProductDtoForCreate;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ProductDtoForCreate create){
		var response = productService.add(create);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		var response = productService.getAll();
		return ResponseEntity
				.status(response.getHttpStatus())
				.body(response);
	}
	
	@GetMapping("/getProductByCategoryId")
	public ResponseEntity<?> getProductByCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int id){
		var response = productService.getProductByCategoryId(productName, id);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
	@GetMapping("/getProductsByCategoryId")
	public ResponseEntity<?>  getProductsByCategoryId(@RequestParam("categoryId") int id){
		var response= productService.getByCategoryId(id);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
}







