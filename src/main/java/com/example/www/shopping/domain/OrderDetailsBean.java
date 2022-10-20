package com.example.www.shopping.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "ORDERDETAILS")
public class OrderDetailsBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer orderdetailsid;
	
	public Integer getOrderdetailsid() {
		return orderdetailsid;
	}

	public void setOrderdetailsid(Integer orderdetailsid) {
		this.orderdetailsid = orderdetailsid;
	}

	@Column(name = "ORDERID")
	private Integer orderid;
	
//	@Column(name = "ORDERDATE")
//	private java.util.Date orderdate;
	
	@Column(name = "LNAME")
	private String lname;
	
	@Column(name = "quantity")
	private String quantity;

	@Column(name = "name")
	private String name;
	
	@Column(name = "ADDRESS")
	private java.lang.String address;
	

	
	@Column(name = "PAYMENTSTATUS")
	private String paymentstatus;
	
	@Column(name = "SHIPPINGMETHOD")
	private String shippingmethod;
	
	@Column(name = "SHIPPINGSTATUS")
	private String shippingstatus;



	@Override
	public String toString() {
		return "OrderDetailsBean [orderdetailsid=" + orderdetailsid + ", orderid=" + orderid 
				+ ", lname=" + lname + ", quantity=" + quantity + ", name=" + name + ", address=" + address
				+ ", paymentstatus=" + paymentstatus + ", shippingmethod=" + shippingmethod + ", shippingstatus="
				+ shippingstatus + "]";
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

//	public java.util.Date getOrderdate() {
//		return orderdate;
//	}

//	public void setOrderdate(java.util.Date orderdate) {
//		this.orderdate = orderdate;
//	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}





	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public String getShippingmethod() {
		return shippingmethod;
	}

	public void setShippingmethod(String shippingmethod) {
		this.shippingmethod = shippingmethod;
	}

	public String getShippingstatus() {
		return shippingstatus;
	}

	public void setShippingstatus(String shippingstatus) {
		this.shippingstatus = shippingstatus;
	}
	
}
