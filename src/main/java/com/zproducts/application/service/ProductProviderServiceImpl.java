/**
 * 
 */
package com.zproducts.application.service;

import com.zprices.generatedsources.model.Product;
import com.zproducts.application.ports.in.ProductsService;
import com.zproducts.infrastructure.entity.ProductEntity;
import com.zproducts.infrastructure.mapper.ProductMapper;
import com.zproducts.application.ports.out.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation to provide a list of {@link Product}
 */
@Service
public class ProductProviderServiceImpl implements ProductsService {
	
	private static final Logger logger = LogManager.getLogger(ProductProviderServiceImpl.class);
	private ProductRepository repository;
	private ProductMapper mapper;



	/**
	 * Constructor CDI
	 * @param repository
	 * @param mapper
	 */
	@Autowired
	public ProductProviderServiceImpl(ProductRepository repository, ProductMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<Product> getProducts(String applyDate, Integer productId, Integer brandId) throws IllegalStateException {
		List<Product> productList = new ArrayList<>();
		List<ProductEntity> productEntityList = null;
		productEntityList = repository.findProductsByProductIdAndBrandIdAndDate(productId, brandId, applyDate);
		if (productEntityList == null) {
			logger.error("Something went wrong when accessing data.");
			throw new IllegalStateException("Something went wrong when accessing data.");
		}
		for (ProductEntity pEntity : productEntityList) {
			productList.add(mapper.productEntityToProduct(pEntity));
		}
		
		return productList;
	}
	
	/**
	 * @return class logger
	 */
	protected Logger getLogger() {
		return logger;
	}

}
