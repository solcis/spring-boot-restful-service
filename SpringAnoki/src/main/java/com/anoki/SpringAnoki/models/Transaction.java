package com.anoki.SpringAnoki.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long transactionId;
	@Column(name="date", nullable=false)
	private Date date;
	@Column(name="amount", nullable=false, scale = 2, precision = 8)
	private BigDecimal amount;
	@Column(name="description", nullable=false)
	private String description;
	
	private Transaction() {
	}

	public Transaction(Date date, BigDecimal amount, String description) {
		this();
		this.date = date;
		this.amount = amount;
		this.description = description;
	}


	public Long getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", date=" + date + ", amount=" + amount
				+ ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
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
		Transaction other = (Transaction) obj;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}

}
