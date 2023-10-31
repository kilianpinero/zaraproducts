package com.zproducts.application.ports.out;

import com.zproducts.infrastructure.entity.ProductEntity;

/**
 * Interface of domain outlet
 */

public interface ProductServiceOut {

    /**
     * Retrieves product form repo
     *
     * @param productId
     * @param brandId
     * @param applyDate
     * @return
     */
    public ProductEntity getProductFromRepo(Integer productId, Integer brandId, String applyDate);
}
