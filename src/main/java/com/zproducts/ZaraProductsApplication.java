package com.zproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.zproducts.*")
@ComponentScan(basePackages = { "com.zproducts.*" })
@EntityScan("com.zproducts.*")  
public class ZaraProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaraProductsApplication.class, args);
	}

}
