package com.fas10ver.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fas10ver.business.abstracts.BusinessService;
import com.fas10ver.business.abstracts.CompanyService;
import com.fas10ver.dataAccess.BusinessDao;
import com.fas10ver.entities.Business;
import com.fas10ver.entities.Company;
import com.fas10ver.entities.dtos.businessDto.BusinessDtoForCreate;
import com.fas10ver.entities.models.ApiResponse;
import com.fas10ver.exceptions.BusinessNotFoundException;

@Service
public class BusinessManager  implements BusinessService{
	
	private BusinessDao businessDao;
	private ModelMapper mapper;
	private CompanyService companyService;

	@Autowired
	public BusinessManager(BusinessDao businessDao, ModelMapper mapper, CompanyService companyService) {
		this.businessDao = businessDao;
		this.mapper = mapper;
		this.companyService = companyService;
	}

	@Override
	public ApiResponse<List<Business>> getAll() {
		List<Business> list = businessDao.findAll();
		return ApiResponse.default_OK(list);
		 
	}

	@Override
	public ApiResponse<Business> getOneBusiness(int businessId) {
		Business business = businessDao.findById(businessId).orElseThrow(()->new BusinessNotFoundException(businessId));
		return ApiResponse.default_OK(business);
	}
	
	

	@Override
	public ApiResponse<Business> add(BusinessDtoForCreate businessDtoForCreate) {
		
		Business business = mapper.map(businessDtoForCreate, Business.class);
		Company company = companyService.getOneCompany(businessDtoForCreate.getCompanyId()).getData();
		business.setCompany(company);
		return ApiResponse.default_CREATED(businessDao.save(business));
	}

}
