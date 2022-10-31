package com.fas10ver.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fas10ver.business.abstracts.CompanyService;
import com.fas10ver.dataAccess.CompanyDao;
import com.fas10ver.entities.Company;
import com.fas10ver.entities.dtos.companyDto.CompanyDtoForCreaate;
import com.fas10ver.entities.models.ApiResponse;
import com.fas10ver.exceptions.CompanyNotFoundException;

@Service
public class CompanyManager  implements CompanyService{

	private CompanyDao companyDao;
	private ModelMapper mapper;
	
	
	@Autowired
	public CompanyManager(CompanyDao companyDao, ModelMapper mapper) {
		this.companyDao = companyDao;
		this.mapper = mapper;
	}

	@Override
	public ApiResponse<List<Company>> getAll() {
		List<Company> list = companyDao.findAll();
		return ApiResponse.default_OK(list);
	}

	@Override
	public ApiResponse<Company> getOneCompany(int CompanyId) {
		var response = companyDao.findById(CompanyId).orElseThrow(()->new CompanyNotFoundException(CompanyId));
		return ApiResponse.default_OK(response);
	}

	@Override
	public ApiResponse<Company> add(CompanyDtoForCreaate companyDtoForCreaate) {
		Company company = mapper.map(companyDtoForCreaate, Company.class); 
		companyDao.save(company);
		return ApiResponse.default_CREATED(company);
	}

}
