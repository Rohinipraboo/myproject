package com.example.onlinepizzaordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinepizzaordering.model.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	
	
ShoppingCart findBySessionToken(String sessionToken);



}
