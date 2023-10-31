package com.zproducts.rest;

import com.zproducts.application.ports.in.ProductsService;
import com.zproducts.generatedsources.api.ProductpricesApi;
import com.zproducts.generatedsources.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class ProductsController implements ProductpricesApi {

	private ProductsService service;

	@Autowired
	public ProductsController(ProductsService service) {
		this.service = service;
	}


	@Override
	public ResponseEntity<Product> getProducts(String applyDate, Integer productId, Integer brandId) {
		Product product = service.getProducts(applyDate, productId, brandId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
}
