package com.fas10ver.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas10ver.entities.Product;

public interface ProductDao  extends JpaRepository<Product, Integer>{
	
	Product getByNameAndCategory_CategoryId(String name, int id);
	List<Product> getByCategory_CategoryId(int id);
			
}
