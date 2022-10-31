package com.fas10ver.business.abstracts;

import java.util.List;

import com.fas10ver.entities.Offer;
import com.fas10ver.entities.dtos.offerDto.OfferDtoForCreate;
import com.fas10ver.entities.dtos.offerDto.OfferDtoForUpdate;
import com.fas10ver.entities.models.ApiResponse;

public interface OfferService {
	
	public ApiResponse<List<Offer>> getAll();
	public ApiResponse<Offer> getOneOffer(int offerId);
	public ApiResponse<Offer> add(OfferDtoForCreate offerDtoForCreate);
	public ApiResponse<Offer> update(OfferDtoForUpdate offerDtoForUpdate, int OfferId); 
	
	public ApiResponse<List<Offer>> getOfferByBusinessId(int id);
	public ApiResponse<List<Offer>> getOfferByApprovalStatusFalse();
	
}
