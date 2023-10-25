package com.zproducts.infrastructure.adapter;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.Id;

import jakarta.persistence.Column;

@Entity
@Table(name = "prices")
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
	  
	  


	// Add public getter and setter methods for each attribute
	  public Integer getProductId() {
	    return productId;
	  }

	  public void setProductId(Integer productId) {
	    this.productId = productId;
	  }

	  public Integer getBrandId() {
	    return brandId;
	  }

	  public void setBrandId(Integer brandId) {
	    this.brandId = brandId;
	  }

	  public Integer getPriceList() {
	    return priceList;
	  }

	  public void setPriceList(Integer priceList) {
	    this.priceList = priceList;
	  }

	  public String getStartDate() {
	    return startDate;
	  }

	  public void setStartDate(String startDate) {
	    this.startDate = startDate;
	  }

	  public String getEndDate() {
	    return endDate;
	  }

	  public void setEndDate(String endDate) {
	    this.endDate = endDate;
	  }

	  public Double getPrice() {
	    return price;
	  }

	  public void setPrice(Double price) {
	    this.price = price;
	  }
	

}
