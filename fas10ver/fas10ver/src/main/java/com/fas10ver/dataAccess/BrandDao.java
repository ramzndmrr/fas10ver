package com.fas10ver.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas10ver.entities.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer>{

	
	/*
	 * örnek sorgular
	 * ProductComment getByComment(String comment); ProductComment
	 * getByCommentAndProduct_ProductId(String comment, int productId);
	 */
	 
	
	//select * from Category c inner join Product p 
	//on c.categoryId =p.categoryId
		
		
	//select p.productId, p.productName, c.categroyName from Category c inner join Product p 
	//on c.categoryId =p.categoryId
	
	
	/*
	 * dto ile product detayını getirmek
	 * 
	 * @Query("Select new   com.ftteknoloji.entities.Product" +
	 * "(p.productId, p.ProductName, c.categoryName)" +
	 * " From Category c Inner Join c.products p") List<Product> getProductDetail();
	 */
}
