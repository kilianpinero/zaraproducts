package com.zproducts.application.ports.in;

import com.zproducts.generatedsources.model.Product;

/**
 * Service that provides a list of products
 */

public interface ProductsService {
	
	/**
	 * Provides a list of products depending on params
	 * @return List of products
	 * @throws IllegalStateException
	 */
	Product getProducts(String applyDate, Integer productId, Integer brandId) throws IllegalStateException;

}
