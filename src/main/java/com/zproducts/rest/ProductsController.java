package com.zproducts.rest;

import com.zproducts.application.ports.in.ProductsService;
import com.zproducts.application.service.ProductProviderServiceImpl;
import com.zproducts.generatedsources.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class ProductsController implements ProductsService{

	private ProductProviderServiceImpl service;

	@Autowired
	public ProductsController(ProductProviderServiceImpl service) {
		this.service = service;
	}

	@Override
	@GetMapping("/productprices")
	public Product getProducts(String applyDate, Integer productId, Integer brandId) throws IllegalStateException {
		return service.getProducts(applyDate, productId, brandId).getBody();
//		return new ResponseEntity<>(products, HttpStatus.OK);
	}


}
