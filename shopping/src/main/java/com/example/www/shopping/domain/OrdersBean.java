package com.example.www.shopping.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class OrdersBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDERID")
	private Integer orderid;
	
//	@Column(name = "ORDERDATE")
//	private java.util.Date orderdate;
	
	@Column(name = "TOTAL")
	private Integer total;
	
	@Column(name = "PAYMENTSTATUS")
	private String paymentstatus;

	@Column(name = "NOTES")
	private String notes;

	@Override
	public String toString() {
		return "OrdersBean [orderid=" + orderid  + ", total=" + total + ", paymentstatus="
				+ paymentstatus + ", notes=" + notes + "]";
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
