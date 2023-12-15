/**
 *
 */
package com.zproducts.application.service;

import com.zproducts.application.ports.in.ProductsService;
import com.zproducts.application.ports.out.ProductServiceOut;
import com.zproducts.generatedsources.model.Product;
import com.zproducts.infrastructure.entity.ProductEntity;
import com.zproducts.infrastructure.mapper.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service implementation to provide a list of {@link Product}
 */
@Service
public class ProductProviderServiceImpl implements ProductsService {

    private final ProductServiceOut service;

    @Autowired
    public ProductProviderServiceImpl(ProductServiceOut service) {
        this.service = service;
    }

    @Override
    public Optional<Product> getProducts(String applyDate, Integer productId, Integer brandId) {
        Optional<ProductEntity> pEntity = service.getProductFromRepo(productId, brandId, applyDate);
        return Optional.ofNullable(ProductEntityMapper.INSTANCE.productEntityToProduct(pEntity.get()));
    }


}
