package com.shopping.SportsShoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cartitems")
public class CartItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long 	Id;
	
	private long	productId;
	private long	quantity;
	private Float	unitPrice;
	private	boolean paymentStatus;
	
	
	public CartItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CartItems(long productId, long quantity, Float unitPrice, boolean paymentStatus) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.paymentStatus = paymentStatus;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public Float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Cart [Id=" + Id + ", productId=" + productId + ", quantity=" + quantity + ", unitPrice=" + unitPrice
				+ ", paymentStatus=" + paymentStatus + "]";
	}	
	

}
