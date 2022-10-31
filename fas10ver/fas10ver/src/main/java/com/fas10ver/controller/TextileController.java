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

import com.fas10ver.business.abstracts.TextileService;
import com.fas10ver.entities.dtos.textileDto.TextileDtoForCreate;


@RestController
@RequestMapping("api/v1/textiles")
@CrossOrigin
public class TextileController {
	
	private TextileService textileService;

	@Autowired
	public TextileController(TextileService textileService) {
		this.textileService = textileService;
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		var response = textileService.getAll();
		return ResponseEntity
				.status(response.getHttpStatus())
				.body(response);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getOneTextile(@PathVariable(name = "id",required = true) int id){
		var response = textileService.getOneTextile(id);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody TextileDtoForCreate textileDtoForCreate){
		var response = textileService.add(textileDtoForCreate);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
}
