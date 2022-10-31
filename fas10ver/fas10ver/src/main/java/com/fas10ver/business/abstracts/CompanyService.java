package com.fas10ver.business.abstracts;

import java.util.List;


import com.fas10ver.entities.Company;
import com.fas10ver.entities.dtos.companyDto.CompanyDtoForCreaate;
import com.fas10ver.entities.models.ApiResponse;

public interface CompanyService {
	

	public ApiResponse<List<Company>> getAll();
	public ApiResponse<Company> getOneCompany(int CompanyId);
	public ApiResponse<Company> add(CompanyDtoForCreaate companyDtoForCreaate);

}
