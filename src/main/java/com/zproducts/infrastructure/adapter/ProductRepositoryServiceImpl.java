package com.zproducts.infrastructure.adapter;

import com.zproducts.application.ports.out.ProductServiceOut;
import com.zproducts.infrastructure.entity.ProductEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer to retrieve repository product info
 */
@Service
public class ProductRepositoryServiceImpl implements ProductServiceOut {

    private static final Logger logger = LogManager.getLogger(ProductRepositoryServiceImpl.class);
    private ProductRepository repository;

    @Autowired
    public ProductRepositoryServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductEntity getProductFromRepo(Integer productId, Integer brandId, String applyDate) {
        List<ProductEntity> productEntityList = repository.findProductsByProductIdAndBrandIdAndDate(productId, brandId, applyDate);
        if (productEntityList == null) {
            logger.error("Something went wrong when accessing data.");
            throw new IllegalStateException("Something went wrong when accessing data.");
        }

        return getHighPriorityProduct(productEntityList);

    }

    /**
     * gets high priority product from list
     *
     * @param productEntityList
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

    /**
     * @return class logger
     */
    protected Logger getLogger() {
        return logger;
    }

}