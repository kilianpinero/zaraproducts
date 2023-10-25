package com.zproducts.infrastructure.adapter;

import org.springframework.stereotype.Service;

import com.zprices.generatedsources.model.Product;

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
	    return product;
	}

}
