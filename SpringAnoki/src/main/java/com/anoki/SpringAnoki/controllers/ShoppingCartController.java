package com.anoki.SpringAnoki.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anoki.SpringAnoki.models.Content;
import com.anoki.SpringAnoki.models.ShoppingCart;
import com.anoki.SpringAnoki.services.ShoppingCartService;

@RestController
@RequestMapping("/api/shoppingcart")
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartService cartService;
	
	@GetMapping
	public Iterable<ShoppingCart> findAll(){
		return cartService.findAll();
	}
	
	@GetMapping("/{id}")
	public ShoppingCart findById(@PathVariable Long id){
		return cartService.findById(id);
	}
	
	@GetMapping("/{id}/items")
	public List<Content> cartItems(@PathVariable Long id){
		ShoppingCart sc = cartService.findById(id);
		return sc.getItems();
	}

}
