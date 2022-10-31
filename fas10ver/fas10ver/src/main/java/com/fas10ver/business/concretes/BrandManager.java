package com.fas10ver.business.concretes;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fas10ver.business.abstracts.BrandService;
import com.fas10ver.dataAccess.BrandDao;
import com.fas10ver.entities.Brand;
import com.fas10ver.entities.dtos.brandDto.BrandDtoForCreate;
import com.fas10ver.entities.dtos.brandDto.BrandDtoForUpdate;
import com.fas10ver.entities.models.ApiResponse;
import com.fas10ver.exceptions.BrandNotFoundException;

@Service
public class BrandManager implements BrandService{
	
	private BrandDao brandDao;
	private ModelMapper modelMapper;
	
	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapper modelMapper) {
		this.brandDao = brandDao;
		this.modelMapper = modelMapper;
	}


	@Override
	public ApiResponse<Brand> add(BrandDtoForCreate brandDtoForCreate) {
		
		Brand brand = modelMapper.map(brandDtoForCreate, Brand.class);
		brandDao.save(brand);
		return ApiResponse.default_CREATED(brand);
	}

	@Override
	public ApiResponse<Brand> update(int id, BrandDtoForUpdate brandDtoForUpdate) {
		Brand brand =  getOneBrand(id).getData();
		
		 brand.setName(brandDtoForUpdate.getName());
		 
		 //buraya machine service interfacesinden machine listesi gelicek
		// brand.setMachines(brandDtoForUpdate.getMachineIds());
		
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ApiResponse<Brand> getOneBrand(int brandId) {
		Brand brand= brandDao.findById(brandId)
				.orElseThrow(()-> new BrandNotFoundException(brandId) );
		return ApiResponse.default_OK(brand);
	}


	@Override
	public ApiResponse<List<Brand>> getAllBrand() {
		List<Brand> list = brandDao.findAll();
		return ApiResponse.default_OK(list);
	}

}
