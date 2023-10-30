/**
 * 
 */
package com.zproducts.application.service;

import com.zproducts.generatedsources.api.ProductpricesApi;
import com.zproducts.generatedsources.model.Product;
import com.zproducts.infrastructure.adapter.ProductRepositoryServiceImpl;
import com.zproducts.infrastructure.entity.ProductEntity;
import com.zproducts.infrastructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Service implementation to provide a list of {@link Product}
 */
@Service
public class ProductProviderServiceImpl implements ProductpricesApi {
	
	private ProductMapper mapper;
	private ProductRepositoryServiceImpl service;

	@Autowired
	public ProductProviderServiceImpl(ProductMapper mapper, ProductRepositoryServiceImpl service) {
		this.mapper = mapper;
		this.service = service;
	}

	@Override
	public ResponseEntity<Product> getProducts(String applyDate, Integer productId, Integer brandId) {
		ProductEntity pEntity = service.getProductFromRepo(productId,brandId,applyDate);
		Product product = mapper.productEntityToProduct(pEntity);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}



}
