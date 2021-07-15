package com.shopping.SportsShoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "payment")
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long 	Id;
	
	private String 	firstName;
	private String 	lastName;
	private String 	email;
	private String 	phoneNo;
	private String 	cardNo;
	private String 	expiryDate;
	private String 	totalAmount;
	
	
	public PaymentDetails() {
	}
	


	public PaymentDetails(String firstName, String lastName, String email, String phoneNo, String cardNo,
			String expiryDate, String totalAmount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.cardNo = cardNo;
		this.expiryDate = expiryDate;
		this.totalAmount = totalAmount;
	}



	public long getId() {
		return Id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "PaymentDetails [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", cardNo=" + cardNo + ", expiryDate=" + expiryDate + ", totalAmount="
				+ totalAmount + "]";
	}
	
	
}
