package com.anoki.SpringAnoki.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long customerId;
	@Column(name="name", nullable=false)
	private String username;
	@Column(name="password", nullable=false)
	private String password;
	@Column(name="wallet", nullable=false)
	private BigDecimal wallet;
	@OneToOne(cascade=CascadeType.ALL)
	private ShoppingCart sc;
	@OneToMany(mappedBy="transactionId")
	private List<Transaction> transactions;
	
	private Customer() {
	}

	public Customer(String username, String password) {
		this();
		this.username = username;
		this.password = password;
		this.wallet = BigDecimal.ZERO;
		this.sc = new ShoppingCart();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getWallet() {
		return wallet;
	}

	public void setWallet(BigDecimal wallet) {
		this.wallet = wallet;
	}

	public ShoppingCart getSc() {
		return sc;
	}

	public void setSc(ShoppingCart sc) {
		this.sc = sc;
	}

	public Long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", password=" + password + ", wallet="
				+ wallet + ", sc=" + sc + ", transactions=" + transactions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}
	
}
