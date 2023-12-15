package com.zproducts.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prices")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
	
	  @Id
	  @Column(name = "id")
	  private Integer id;

	  @Column(name = "product_id")
	  private Integer productId;

	  @Column(name = "brand_id")
	  private Integer brandId;

	  @Column(name = "price_list")
	  private Integer priceList;

	  @Column(name = "start_date")
	  private String startDate;

	  @Column(name = "end_date")
	  private String endDate;

	  @Column(name = "price")
	  private Double price;
	  
	  @Column(name = "priority")
	  private Integer priority;
	  
	  @Column(name = "curr")
	  private String curr;
	  
}
