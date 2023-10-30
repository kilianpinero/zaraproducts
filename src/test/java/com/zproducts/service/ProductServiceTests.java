package com.zproducts.service;

import com.zproducts.application.service.ProductProviderServiceImpl;
import com.zproducts.generatedsources.model.Product;
import com.zproducts.infrastructure.adapter.ProductRepositoryServiceImpl;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceTests {

    @Autowired
    private ProductRepositoryServiceImpl repoService;
    @Autowired
    private ProductMapper mapper;
    private ProductProviderServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new ProductProviderServiceImpl(mapper, repoService);
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
        ResponseEntity<Product> response = service.getProducts(applyDate, productId, brandId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}