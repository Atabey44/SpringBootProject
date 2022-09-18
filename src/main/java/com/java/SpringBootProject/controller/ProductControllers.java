package com.java.SpringBootProject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringBootProject.business.abstracts.ProductService;
import com.java.SpringBootProject.core.utilities.results.DataResult;
import com.java.SpringBootProject.core.utilities.results.Result;
import com.java.SpringBootProject.entities.concretes.Product;
import com.java.SpringBootProject.entities.dtos.ProductWithCategoryDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/product")
public class ProductControllers {
				
					private ProductService productService;
					
					public ProductControllers(ProductService productService) {
						super();
						this.productService = productService;
					}


					@GetMapping("/getall")
					public DataResult<List<Product>> gettAll(){
						return  this.productService.getAll();
					}
					
					
					@PostMapping("/add")
					public Result add(@RequestBody Product product) {
						return this.productService.add(product);
					}
					
				
					@GetMapping("/getByProductName")
				public DataResult<Product> getByProductName(@RequestParam String productName) {
				return this.productService.getByProductName(productName);
					}
			
					@GetMapping("/getByProductNameAndCategoryId")
					public DataResult<Product> getByProductNameAndCategory_CategoryId( @RequestParam String productName, @RequestParam 	int categoryId) {
						return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId); 
								}

					@GetMapping("/getByProductNameOrCategoryId")
					public DataResult<List<Product>> getByProductNameOrCategory(@RequestParam String productName, @RequestParam 	int categoryId) {
					return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId); 
							}

					@GetMapping("/getByCategoryIdIn")
					public DataResult<List<Product>> getByCategoryIn(@RequestParam List<Integer> categories) {
						return this.productService.getByCategory_CategoryIdIn(categories); 
								}

				@GetMapping("/getByProductNameContains")
					public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
				  return this.productService.getByProductNameContains(productName);
					}
 
					@GetMapping("/getByProductNameStartsWith")
					public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
					return this.productService.getByProductNameStartsWith(productName);
					}
					
					@GetMapping("/getAllPage")		
					public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
						return this.productService.getAll(pageNo, pageSize);			
									
						}
					@GetMapping("/getAllSorted")
					public DataResult<List<Product>> getAllSorted() {
						   	return this.productService.getAllSorted();
							}
					
					@GetMapping("/getProductWithCategoryDetails")
					public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
						return this.productService.getProductWithCategoryDetails();
					}
					
}
