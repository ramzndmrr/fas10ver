package com.fas10ver.business.abstracts;

import java.util.List;

import com.fas10ver.entities.Business;
import com.fas10ver.entities.dtos.businessDto.BusinessDtoForCreate;
import com.fas10ver.entities.models.ApiResponse;

public interface BusinessService {

	public ApiResponse<List<Business>> getAll();
	public ApiResponse<Business> getOneBusiness(int businessId);
	public ApiResponse<Business> add(BusinessDtoForCreate businessDtoForCreate);
	
}
