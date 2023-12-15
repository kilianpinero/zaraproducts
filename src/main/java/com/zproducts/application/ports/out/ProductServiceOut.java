package com.zproducts.application.ports.out;

import com.zproducts.infrastructure.entity.ProductEntity;

import java.util.Optional;

/**
 * Interface of domain outlet
 */

public interface ProductServiceOut {

    /**
     * Retrieves product form repo
     *
     * @param productId Product Id
     * @param brandId   Brand Id
     * @param applyDate Apply Date
     * @return Returns Product Entity data
     */
    Optional<ProductEntity> getProductFromRepo(Integer productId, Integer brandId, String applyDate);
}
