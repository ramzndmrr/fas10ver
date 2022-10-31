package com.fas10ver.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fas10ver.business.abstracts.CategoryService;
import com.fas10ver.dataAccess.CategoryDao;
import com.fas10ver.entities.Category;
import com.fas10ver.entities.dtos.categoryDto.CategoryDtoForCreate;
import com.fas10ver.entities.models.ApiResponse;
import com.fas10ver.exceptions.BrandNotFoundException;
import com.fas10ver.exceptions.CategoryNotFoundException;

@Service
public class CategoryManager implements CategoryService{

	
	private CategoryDao categoryDao;
	private ModelMapper mapper;
	
	@Autowired
	public CategoryManager(CategoryDao categoryDao, ModelMapper mapper) {
		this.categoryDao = categoryDao;
		this.mapper = mapper;
	}

	
	
	@Override
	public ApiResponse<Category> add(CategoryDtoForCreate forCreate) {
		Category category = mapper.map(forCreate, Category.class);
		return ApiResponse.default_CREATED(categoryDao.save(category));
	}

	@Override
	public ApiResponse<List<Category>> getAll() {
		List<Category> list = categoryDao.findAll();
		return ApiResponse.default_OK(list);
	}



	@Override
	public ApiResponse<Category> getOneCategory(int id) {
		var response = categoryDao.findById(id)
				.orElseThrow(()-> new BrandNotFoundException(id) );
		return ApiResponse.default_OK(response);
	}

}
