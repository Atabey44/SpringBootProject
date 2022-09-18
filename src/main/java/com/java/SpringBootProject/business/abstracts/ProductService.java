package com.java.SpringBootProject.business.abstracts;

import java.util.List;

import com.java.SpringBootProject.core.utilities.results.DataResult;
import com.java.SpringBootProject.core.utilities.results.Result;
import com.java.SpringBootProject.entities.concretes.Product;
import com.java.SpringBootProject.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
					
					DataResult<List<Product>> getAll();
					
					DataResult<List<Product>> getAllSorted();
					
					Result add(Product product);
					
					DataResult<Product> getByProductName(String productName);
					
					DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);
					
					DataResult<List<Product>>  getByProductNameOrCategory_CategoryId(String productName, int categoryId);
					
					DataResult<List<Product>>  getByCategory_CategoryIdIn(List<Integer> categories);

					DataResult<List<Product>>  getByProductNameContains(String productName);
					
					DataResult<List<Product>> getByProductNameStartsWith(String productName);
					
					DataResult<List<Product>> getAll(int pageNo, int pageSize);
					
					 DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
