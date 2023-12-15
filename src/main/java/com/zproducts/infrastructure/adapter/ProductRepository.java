/**
 *
 */
package com.zproducts.infrastructure.adapter;

import com.zproducts.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


/**
 * Interface product repository
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Serializable> {
    /**
     * Retrieves list of products that matches date, productId and brandId
     *
     * @param startDate Application date
     * @param endDate Application date
     * @param productId Product id
     * @param brandId Branch Id
     * @return List of products
     */

    List<ProductEntity> findByProductIdAndBrandIdAndEndDateIsGreaterThanEqualAndStartDateIsLessThanEqual(Integer productId, Integer brandId, String startDate, String endDate);
}
