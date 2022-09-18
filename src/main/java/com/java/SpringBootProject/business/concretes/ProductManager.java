package com.java.SpringBootProject.business.concretes;
 
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.java.SpringBootProject.business.abstracts.ProductService;
import com.java.SpringBootProject.core.utilities.results.DataResult;
import com.java.SpringBootProject.core.utilities.results.Result;
import com.java.SpringBootProject.core.utilities.results.SuccessDataResult;
import com.java.SpringBootProject.core.utilities.results.SuccessResult;
import com.java.SpringBootProject.entities.concretes.Product;
import com.java.SpringBootProject.entities.dtos.ProductWithCategoryDto;
import com.java.SpringBootProject.repository.abstracts.ProductRepository;

@Service
public class ProductManager implements ProductService{
						
						private ProductRepository productRepository;

						public ProductManager(ProductRepository productRepository) {
							super();
							this.productRepository = productRepository;
						}
						@Override
						public DataResult<List<Product>> getAll() {
							return new SuccessDataResult<List<Product>>( 	this.productRepository.findAll() , "Tüm ürünler başarıyla listelendi...");
					  }
						@Override
						public Result add(Product product) {
							this.productRepository.save(product);
						return new SuccessResult("Ürün  Başarıyla Eklendi...");
						}

						@Override
						public DataResult<Product> getByProductName(String productName) {
					return new SuccessDataResult<Product>
					(this.productRepository.getByProductName(productName), "Ürün Başarıyla Listelendi...");
						}

						@Override
						public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName,  	int categoryId) {
							return new SuccessDataResult<Product>
							(this.productRepository.getByProductNameAndCategory_CategoryId(productName, categoryId), "Ürün Başarıyla Listelendi...");
						}

						@Override
						public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName,  	int categoryId) {
						return new SuccessDataResult<List<Product>>
						(this.productRepository.getByProductNameOrCategory_CategoryId(productName, categoryId), "Ürün Başarıyla Listelendi...");
						}

						@Override
						public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
							return new SuccessDataResult<List<Product>>
							(this.productRepository.getByCategory_CategoryIdIn(categories), "Kategori Başarıyla Listelendi...");
						}

						@Override
						public DataResult<List<Product>> getByProductNameContains(String productName) {
					  return new SuccessDataResult<List<Product>>
					  (this.productRepository.getByProductNameContains(productName), "Ürün Başarıyla Listelendi...");
						}

						@Override
						public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
						return new SuccessDataResult<List<Product>>
						(this.productRepository.getByProductNameStartsWith(productName), "Ürün Başarıyla Listelendi...");
						}
						@Override
						public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
						Pageable pageable = PageRequest.of(pageNo-1, pageSize);
							return new SuccessDataResult<List<Product>>
							(this.productRepository.findAll(pageable).getContent(),"Sayfalar Başarıyla Listelendi...");									
						}
						
						@Override
						public DataResult<List<Product>> getAllSorted() {
					   Sort sort = Sort.by(Sort.Direction.DESC, "productName" );
							return new SuccessDataResult<List<Product>>(this.productRepository.findAll(sort), "Ürünler Başarıyla Sıralandı...");
						}
						@Override
						public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
							return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productRepository.getProductWithCategoryDetails(), "Başarıyla Listelendi...");
						}
						
					
}
