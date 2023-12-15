package com.zproducts.application.ports.in;

import com.zproducts.generatedsources.model.Product;

import java.util.Optional;

/**
 * Service that provides a list of products
 */

public interface ProductsService {

	/**
	 * +
	 * Provides a list of products depending on params
	 *
	 * @param applyDate Apply Date
	 * @param productId Product ID
	 * @param brandId   Brand ID
	 * @return Returns Product data
	 * @throws IllegalStateException
	 */
	Optional<Product> getProducts(String applyDate, Integer productId, Integer brandId) throws IllegalStateException;

}
