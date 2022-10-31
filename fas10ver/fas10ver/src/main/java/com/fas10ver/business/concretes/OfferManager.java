package com.fas10ver.business.concretes;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fas10ver.business.abstracts.BusinessService;
import com.fas10ver.business.abstracts.OfferService;
import com.fas10ver.business.abstracts.TextileService;
import com.fas10ver.dataAccess.OfferDao;
import com.fas10ver.entities.Business;
import com.fas10ver.entities.Offer;
import com.fas10ver.entities.Textile;
import com.fas10ver.entities.dtos.offerDto.OfferDtoForCreate;
import com.fas10ver.entities.dtos.offerDto.OfferDtoForUpdate;
import com.fas10ver.entities.models.ApiErrorResponse;
import com.fas10ver.entities.models.ApiResponse;
import com.fas10ver.exceptions.OfferNotFoundException;

@Service
public class OfferManager implements OfferService{
	
	
	private OfferDao offerDao;
	private ModelMapper mapper;
	private BusinessService businessService;
	private TextileService textileService;
	
	@Autowired
	public OfferManager(OfferDao offerDao, ModelMapper mapper, BusinessService businessService,
			TextileService textileService) {
		this.offerDao = offerDao;
		this.mapper = mapper;
		this.businessService = businessService;
		this.textileService = textileService;
	}

	@Override
	public ApiResponse<List<Offer>> getAll() {
		List<Offer> list = offerDao.findAll();
		return ApiResponse.default_OK(list);
	}

	@Override
	public ApiResponse<Offer> getOneOffer(int offerId) {
		Offer offer = offerDao.findById(offerId).orElseThrow(()-> new OfferNotFoundException(offerId));
		return ApiResponse.default_OK(offer);
	}

	@Override
	public ApiResponse<Offer> add(OfferDtoForCreate offerDtoForCreate) {
		
	Business business = businessService.getOneBusiness(offerDtoForCreate.getBusinessId()).getData();
	Textile textile = textileService.getOneTextile(offerDtoForCreate.getTextileId()).getData();
	if(checkIfOfferInvalid(business.getOffers())) {
		Offer offer = mapper.map(offerDtoForCreate, Offer.class);
		offer.setBusiness(business);
		offer.setTextile(textile);
		return ApiResponse.default_CREATED(offerDao.save(offer));
			
	}
	else {
		return ApiErrorResponse.default_NO_CONTENT(null);
	}
	
	}

	@Override
	public ApiResponse<Offer> update(OfferDtoForUpdate offerDtoForUpdate, int OfferId) {
		
		//offer update işlemini sadece company yapabilir.
		Offer offer = getOneOffer(OfferId).getData();
		Double contractPrice = businessService.getOneBusiness(offerDtoForUpdate.getBusinessId()).getData().getContractPrice();
		if(offer.getContractPrice()<contractPrice) {
			return ApiErrorResponse.default_NO_CONTENT(null);
		}else {
			//burada teklifi onayladık ve işin hangi textile ait olduğunu gösterdik
			offer.setApprovalStatus(true);
			Business business = businessService.getOneBusiness(offerDtoForUpdate.getBusinessId()).getData();
			business.setTextile(offer.getTextile());
			return ApiResponse.default_OK(offerDao.save(offer));
		}
	}
	
	
	@Override
	public ApiResponse<List<Offer>> getOfferByBusinessId(int id) {
		getOneOffer(id);
		List<Offer> list = offerDao.findByBusiness_Id(id);
		return ApiResponse.default_OK(list);
	}
	
	@Override
	public ApiResponse<List<Offer>> getOfferByApprovalStatusFalse() {
		List<Offer> list = offerDao.findByApprovalStatusFalse();
		return ApiResponse.default_OK(list);
	}
	
	private boolean checkIfOfferInvalid(List<Offer> offers) {
		List<Offer> ofs = offers.stream().filter(offer->offer.isApprovalStatus()==true).collect(Collectors.toList());
		if(ofs.isEmpty()) {
			return true;
		}
		else return false;
	}

	

	
	


}
