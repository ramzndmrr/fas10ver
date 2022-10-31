package com.fas10ver.business.abstracts;

import java.util.List;

import com.fas10ver.entities.Brand;
import com.fas10ver.entities.dtos.brandDto.BrandDtoForCreate;
import com.fas10ver.entities.dtos.brandDto.BrandDtoForUpdate;
import com.fas10ver.entities.models.ApiResponse;

public interface BrandService {

	ApiResponse<List<Brand>> getAllBrand();
	ApiResponse<Brand> getOneBrand(int brandId);

	ApiResponse<Brand> add(BrandDtoForCreate brandDtoForCreate);
	ApiResponse<Brand> update(int id, BrandDtoForUpdate brandDtoForUpdate);
	void delete(int id);
}
