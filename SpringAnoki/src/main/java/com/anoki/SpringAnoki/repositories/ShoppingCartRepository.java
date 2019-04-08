package com.anoki.SpringAnoki.repositories;

import org.springframework.data.repository.CrudRepository;

import com.anoki.SpringAnoki.models.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
