package com.fas10ver.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fas10ver.business.abstracts.CategoryService;
import com.fas10ver.business.abstracts.ProductService;
import com.fas10ver.dataAccess.ProductDao;
import com.fas10ver.entities.Category;
import com.fas10ver.entities.Product;
import com.fas10ver.entities.dtos.productDto.ProductDtoForCreate;
import com.fas10ver.entities.models.ApiResponse;


@Service
public class ProductManager implements ProductService{
	
	private ProductDao productDao;
	private CategoryService categoryService;
	private ModelMapper mapper;
	
	@Autowired
	public ProductManager(ProductDao productDao, CategoryService categoryService, ModelMapper mapper) {
		this.productDao = productDao;
		this.categoryService = categoryService;
		this.mapper = mapper;
	}

	@Override
	public ApiResponse<Product> add(ProductDtoForCreate forCreate) {
		Category category = categoryService.getOneCategory(forCreate.getCategoryId()).getData();
		Product product = mapper.map(forCreate, Product.class);
		product.setCategory(category);
		productDao.save(product);
		return ApiResponse.default_CREATED(product);
	}

	@Override
	public ApiResponse<List<Product>> getAll() {
		List<Product> list=productDao.findAll();
		return ApiResponse.default_OK(list);
	}

	@Override
	public ApiResponse<Product> getProductByCategoryId(String productName, int categoryId) {
		Product product = productDao.getByNameAndCategory_CategoryId(productName, categoryId);
		return ApiResponse.default_OK(product);
	}

	@Override
	public ApiResponse<List<Product>> getByCategoryId(int id) {
		List<Product> list = productDao.getByCategory_CategoryId(id);
		return ApiResponse.default_OK(list);
	}

}
