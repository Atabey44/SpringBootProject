package com.java.SpringBootProject.repository.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.SpringBootProject.entities.concretes.Product;
import com.java.SpringBootProject.entities.dtos.ProductWithCategoryDto;

public interface ProductRepository extends JpaRepository<Product, Integer> {
			
				Product getByProductName(String productName);
				
				Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
				
				List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
				
				List<Product> getByCategory_CategoryIdIn(List<Integer> categories);

				List<Product> getByProductNameContains(String productName);
				
				List<Product> getByProductNameStartsWith(String productName);
				
				@Query( "Select new com.java.SpringBootProject.entities.dtos.ProductWithCategoryDto"
						+ "(p.id, p.productName, c.categoryName) "
						+ "From Category c Inner Join c.products p ")
				 List<ProductWithCategoryDto> getProductWithCategoryDetails();
}





