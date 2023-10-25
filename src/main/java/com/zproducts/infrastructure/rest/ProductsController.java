package com.zproducts.infrastructure.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zprices.generatedsources.api.ProductpricesApi;
import com.zprices.generatedsources.model.Product;
import com.zproducts.application.ProductProviderServiceImpl;


@RestController
@RequestMapping("/api/v1")
public class ProductsController implements ProductpricesApi{
	
	private ProductProviderServiceImpl service;
	private static final Logger logger = LogManager.getLogger(ProductsController.class);
	
	

	/**
	 * constructor
	 * 
	 * @param service
	 */
	@Autowired
	public ProductsController(ProductProviderServiceImpl service) {
		super();
		this.service = service;
	}



	@Override
	public ResponseEntity<List<Product>> getProducts(String applyDate, Integer productId, Integer brandId) {
		List<Product> products = service.getProductsByProductIdAndBranchIdAndApplyDate(applyDate, productId, brandId);
		if (products.isEmpty()) {
			logger.info("No records found in Products by following parameters: {}, {}, {}",applyDate,brandId,productId);
		}
		
		return new ResponseEntity<>(products,HttpStatus.OK);
	}

	
	/**
	 * @return class logger
	 */
	protected Logger getLogger() {
		return logger;
	}


}
