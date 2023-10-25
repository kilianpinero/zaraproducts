package com.zproducts.application;

import java.util.List;

import com.zprices.generatedsources.model.Product;

/**
 * Service that provides a list of products
 */

public interface ProductsService {
	
	/**
	 * Provides a list of products depending on params
	 * @return
	 * @throws IllegalStateException
	 */
	public List<Product> getProductsByProductIdAndBranchIdAndApplyDate(String applyDate, Integer productId, Integer brandId) throws IllegalStateException;

}
