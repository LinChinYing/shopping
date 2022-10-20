package com.example.www.shopping.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class ProductsBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCTID")
	private Integer productid;
	
	@Column(name = "BRANDID")
	private Integer brandid;
	
	@Column(name = "CATEGORYID")
	private Integer categoryid;
	
	@Column(name = "PRODUCTNAME")
	private String productname;
	
	@Column(name = "PRODUCTPRICE")
	private Integer productprice;
	
	@Column(name = "SOLD")
	private Integer sold;
	
	@Column(name = "RATING")
	private Integer rating;
	
	@Override
	public String toString() {
		return "ProductsBean [productid="+productid + ", brandid="+brandid + ", categoryid="+categoryid + ", productname="+productname + 
				", productprice="+productprice + ", sold="+sold + ", rating="+rating + "]";
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getBrandid() {
		return brandid;
	}

	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}
	
	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getProductprice() {
		return productprice;
	}

	public void setProductprice(Integer productprice) {
		this.productprice = productprice;
	}

	public Integer getSold() {
		return sold;
	}

	public void setSold(Integer sold) {
		this.sold = sold;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	
	
	
}
