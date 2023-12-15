package com.zproducts.infrastructure.mapper;

import com.zproducts.generatedsources.model.Product;
import com.zproducts.infrastructure.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
    /**
     * Instance of the interface
     */
    ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);

    /**
     * Returns product mapped with ProductEntity
     *
     * @param productEntity Product Entity Data
     * @return Returns Product
     */
    Product productEntityToProduct(ProductEntity productEntity);
}
