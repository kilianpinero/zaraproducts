package com.zproducts.infrastructure.adapter;

import com.zproducts.application.ports.out.ProductServiceOut;
import com.zproducts.infrastructure.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer to retrieve repository product info
 */
@Service
public class ProductRepositoryServiceImpl implements ProductServiceOut {

    private final ProductRepository repository;

    @Autowired
    public ProductRepositoryServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<ProductEntity> getProductFromRepo(Integer productId, Integer brandId, String applyDate) {
        List<ProductEntity> productEntityList = repository.findByProductIdAndBrandIdAndEndDateIsGreaterThanEqualAndStartDateIsLessThanEqual(productId, brandId, applyDate, applyDate);
//        if (productEntityList == null || productEntityList.isEmpty()) {
//            logger.error("Something went wrong when accessing data.");
//            throw new IndexOutOfBoundsException();
//        }
        return Optional.ofNullable(getHighPriorityProduct(productEntityList));
    }

    /**
     * gets high priority product from list
     *
     * @param productEntityList Lists of Entities
     * @return highestPriorityObject
     */
    private ProductEntity getHighPriorityProduct(List<ProductEntity> productEntityList) {

        ProductEntity highestPriorityProduct = productEntityList.get(0);
        if (productEntityList.size() > 1) {
            for (int i = 1; i < productEntityList.size(); i++) {
                if (productEntityList.get(i).getPriority() > highestPriorityProduct.getPriority()) {
                    highestPriorityProduct = productEntityList.get(i);
                }
            }
        }
        return highestPriorityProduct;
    }

}