package com.zproducts.service;

import com.zprices.generatedsources.model.Product;
import com.zproducts.application.ports.out.ProductRepository;
import com.zproducts.application.service.ProductProviderServiceImpl;
import com.zproducts.infrastructure.mapper.ProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

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

    @ParameterizedTest(name = "Test {index}: petición con fecha {0} del producto {1} para la brand {2} (ZARA)")
    @CsvSource({
            "2020-06-14 10:00:00, 35455, 1",
            "2020-06-14 16:00:00, 35455, 1",
            "2020-06-14 21:00:00, 35455, 1",
            "2020-06-15 10:00:00, 35455, 1",
            "2020-06-16 21:00:00, 35455, 1"
    })
    public void testGetProductsReturnsProductList(String applyDate, Integer productId, Integer brandId) {
        List<Product> products = service.getProducts(applyDate, productId, brandId);
        ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.OK);
        assertFalse(response.getBody().isEmpty());
    }
}