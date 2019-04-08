package com.anoki.SpringAnoki.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="content")
public class Content {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long itemId;
	@Column(name="type", nullable = false)
	private String type;
	@Column(name="name", nullable = false)
	private String name;
	@Column(name="price", nullable = false, scale = 2, precision = 8)
	private BigDecimal price;
	@Column(name="counter")
	private long counter;	

	private Content() {
	}

	public Content(String type, String name, BigDecimal price) {
		this();
		this.type = type;
		this.name = name;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getItemId() {
		return itemId;
	}
	
	public long getCounter() {
		return counter;
	}

	public void setCounter(long counter) {
		this.counter = counter;
	}

	
	@Override
	public String toString() {
		return "Content [item id=" + itemId + ", type=" + type + ", name=" + name + ", price=" + price + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
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
		Content other = (Content) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		return true;
	}
	
}
