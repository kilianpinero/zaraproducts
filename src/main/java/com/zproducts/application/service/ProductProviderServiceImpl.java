/**
 * 
 */
package com.zproducts.application.service;

import com.zproducts.application.ports.in.ProductsService;
import com.zproducts.application.ports.out.ProductServiceOut;
import com.zproducts.generatedsources.model.Product;
import com.zproducts.infrastructure.entity.ProductEntity;
import com.zproducts.infrastructure.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation to provide a list of {@link Product}
 */
@Service
public class ProductProviderServiceImpl implements ProductsService {
	
	private ProductMapper mapper;
	private ProductServiceOut service;

	@Autowired
	public ProductProviderServiceImpl(ProductMapper mapper, ProductServiceOut service) {
		this.mapper = mapper;
		this.service = service;
	}

	@Override
	public Product getProducts(String applyDate, Integer productId, Integer brandId) {
		ProductEntity pEntity = service.getProductFromRepo(productId,brandId,applyDate);
		return mapper.productEntityToProduct(pEntity);
	}



}
