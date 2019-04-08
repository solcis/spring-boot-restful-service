package com.anoki.SpringAnoki.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long cartId;
	@ManyToMany()
	@JoinTable(
			name = "shoppingcart_content",
			joinColumns = @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "content_id", referencedColumnName = "id"))
	private List<Content> items;

	public ShoppingCart() {
		super();
	}

	public List<Content> getItems() {
		return items;
	}

	public void setItems(List<Content> items) {
		this.items = items;
	}

	public Long getCartId() {
		return cartId;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartId=" + cartId + ", items=" + items + "]";
	}
	
	public List<Content> addItems(Content content){
		getItems().add(content);
		return getItems();
	}

	public List<Content> removeItem(Content content) {
		getItems().remove(content);
		return getItems();
	}

	public BigDecimal sumItems() {
		BigDecimal total = BigDecimal.ZERO;
		for (Content content : items) {
			total = total.add(content.getPrice());
		}
		return total;
	}
	
	public String itemsToString() {
		return "" + this.getItems();
	}

}
