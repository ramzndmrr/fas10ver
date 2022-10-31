package com.fas10ver.business.abstracts;

import java.util.List;

import com.fas10ver.entities.Product;
import com.fas10ver.entities.dtos.productDto.ProductDtoForCreate;
import com.fas10ver.entities.models.ApiResponse;

public interface ProductService {

	ApiResponse<Product> add(ProductDtoForCreate forCreate);
	ApiResponse<List<Product>> getAll();
	
	ApiResponse<Product> getProductByCategoryId(String productName, int categoryId);
	ApiResponse<List<Product>> getByCategoryId(int id);
}
