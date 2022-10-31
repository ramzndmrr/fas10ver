package com.fas10ver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fas10ver.business.abstracts.OfferService;
import com.fas10ver.entities.dtos.offerDto.OfferDtoForCreate;
import com.fas10ver.entities.dtos.offerDto.OfferDtoForUpdate;

@RestController
@RequestMapping("api/v1/offers")
@CrossOrigin
public class OfferController {

	private OfferService offerService;
	public OfferController(OfferService offerService) {
		this.offerService = offerService;
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		var response = offerService.getAll();
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody OfferDtoForCreate offerDtoForCreate){
		var response = offerService.add(offerDtoForCreate);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> update(@RequestBody OfferDtoForUpdate offerDtoForUpdate,@PathVariable(name = "id") int id){
		var response = offerService.update(offerDtoForUpdate, id);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getOfferByBusinessId(@PathVariable(name = "id",required = true) int id){
		var response = offerService.getOfferByBusinessId(id);
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	
	@GetMapping("/getOfferByApprovalStatusFalse")
	public ResponseEntity<?> getOfferByApprovalStatusFalse(){
		var response = offerService.getOfferByApprovalStatusFalse();
		return ResponseEntity.status(response.getHttpStatus()).body(response);
	}
	

	
}
