package com.zproducts.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.zprices.generatedsources.model.Product;
import com.zproducts.application.ProductProviderServiceImpl;
import com.zproducts.infrastructure.adapter.ProductMapper;
import com.zproducts.infrastructure.adapter.ProductRepository;

@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceTests {

    
	@Autowired
	private ProductRepository repository;
	@Autowired
	private ProductMapper mapper;

	private ProductProviderServiceImpl service;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		service = new ProductProviderServiceImpl(repository, mapper);
	}

    @Test
    public void testGetProductsReturnsEmptyList() {
        String applyDate = "2020-01-15 00:00:00";
        Integer productId = 35455;
        Integer brandId = 1;

        List<Product> products = service.getProductsByProductIdAndBranchIdAndApplyDate(applyDate, productId, brandId);
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products,HttpStatus.OK);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isEmpty());
    }

    @Test
    public void testGetProductsReturnsProductListWhenDay14At10() {
        String applyDate = "2020-06-14 10:00:00";
        Integer productId = 35455;
        Integer brandId = 1;

        List<Product> products = service.getProductsByProductIdAndBranchIdAndApplyDate(applyDate, productId, brandId);
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products,HttpStatus.OK);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }
    
    @Test
    public void testGetProductsReturnsProductListWhenDay14At16() {
        String applyDate = "2020-06-14 10:00:00";
        Integer productId = 35455;
        Integer brandId = 1;

        List<Product> products = service.getProductsByProductIdAndBranchIdAndApplyDate(applyDate, productId, brandId);
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products,HttpStatus.OK);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }
    
    @Test
    public void testGetProductsReturnsProductListWhenDay14At21() {
        String applyDate = "2020-06-14 21:00:00";
        Integer productId = 35455;
        Integer brandId = 1;

        List<Product> products = service.getProductsByProductIdAndBranchIdAndApplyDate(applyDate, productId, brandId);
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products,HttpStatus.OK);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }
    
    @Test
    public void testGetProductsReturnsProductListWhenDay15At10() {
        String applyDate = "2020-06-15 10:00:00";
        Integer productId = 35455;
        Integer brandId = 1;

        List<Product> products = service.getProductsByProductIdAndBranchIdAndApplyDate(applyDate, productId, brandId);
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products,HttpStatus.OK);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }
    
    @Test
    public void testGetProductsReturnsProductListWhenDay16At21() {
        String applyDate = "2020-06-16 21:00:00";
        Integer productId = 35455;
        Integer brandId = 1;

        List<Product> products = service.getProductsByProductIdAndBranchIdAndApplyDate(applyDate, productId, brandId);
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products,HttpStatus.OK);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }


}