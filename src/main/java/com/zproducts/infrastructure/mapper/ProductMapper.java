package com.zproducts.infrastructure.mapper;

import com.zproducts.generatedsources.model.Product;
import com.zproducts.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Service;

/**
 * Mapper for entity and dto
 */

@Service
public class ProductMapper {
	
	public Product productEntityToProduct(ProductEntity productEntity) {
	    Product product = new Product();
	    product.setProductId(productEntity.getProductId());
	    product.setBrandId(productEntity.getBrandId());
	    product.setPriceList(productEntity.getPriceList());
	    product.setStartDate(productEntity.getStartDate());
	    product.setEndDate(productEntity.getEndDate());
	    product.setPrice(productEntity.getPrice());
		product.setPriority(productEntity.getPriority());
	    return product;
	}

}
