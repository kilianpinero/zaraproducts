package com.zproducts.application.ports.in;

import com.zprices.generatedsources.model.Product;

import java.util.List;

/**
 * Service that provides a list of products
 */

public interface ProductsService {
	
	/**
	 * Provides a list of products depending on params
	 * @return List of products
	 * @throws IllegalStateException
	 */
	List<Product> getProducts(String applyDate, Integer productId, Integer brandId) throws IllegalStateException;

}
