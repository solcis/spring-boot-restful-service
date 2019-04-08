package com.anoki.SpringAnoki.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.anoki.SpringAnoki.exceptions.ShoppingCartNotFoundException;
import com.anoki.SpringAnoki.models.Content;
import com.anoki.SpringAnoki.models.ShoppingCart;
import com.anoki.SpringAnoki.repositories.ShoppingCartRepository;

@PreAuthorize("hasRole('ADMIN')")
@Service
public class ShoppingCartService {
	
	@Autowired
	ShoppingCartRepository cartRepo;

	public ShoppingCartService() {
	}
		
	public Iterable<ShoppingCart> findAll(){
		return cartRepo.findAll();
	}
	
	public ShoppingCart findById(Long id){
		return cartRepo.findById(id).orElseThrow(ShoppingCartNotFoundException::new);
	}
	
	public List<Content> cartItems(Long id){
		ShoppingCart sc = cartRepo.findById(id).orElseThrow(ShoppingCartNotFoundException::new);
		return sc.getItems();
	}

}
