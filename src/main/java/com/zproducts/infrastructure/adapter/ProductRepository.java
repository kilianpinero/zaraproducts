/**
 * 
 */
package com.zproducts.infrastructure.adapter;

import com.zproducts.infrastructure.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	 * @param applyDate Application date
	 * @param productId Product id
	 * @param brandId Branch Id
	 * @return List of products
	 */
	@Query(value = "SELECT * FROM prices p WHERE p.product_id = :productId AND p.brand_id = :brandId AND p.end_date >= :applyDate AND p.start_date <= :applyDate", nativeQuery = true)
	List<ProductEntity> findProductsByProductIdAndBrandIdAndDate(@Param("productId") Integer productId, @Param("brandId") Integer brandId, @Param("applyDate") String applyDate);
}
