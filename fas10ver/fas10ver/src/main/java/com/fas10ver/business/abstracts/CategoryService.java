package com.fas10ver.business.abstracts;

import java.util.List;

import com.fas10ver.entities.Category;
import com.fas10ver.entities.dtos.categoryDto.CategoryDtoForCreate;
import com.fas10ver.entities.models.ApiResponse;

public interface CategoryService {
	
	
	ApiResponse<Category> add(CategoryDtoForCreate forCreate);
	ApiResponse<List<Category>> getAll();
	ApiResponse<Category> getOneCategory(int id);
}
