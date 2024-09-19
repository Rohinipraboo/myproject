package com.example.onlinepizzaordering.service;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinepizzaordering.model.CartItem;
import com.example.onlinepizzaordering.model.ShoppingCart;
import com.example.onlinepizzaordering.model.pizzas;
import com.example.onlinepizzaordering.repository.CartItemRepository;
import com.example.onlinepizzaordering.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {
	@Autowired
	private HomeService serv;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Autowired
	private CartItemRepository cartItemRepository;
	
	
	

	public ShoppingCart addShoppingCartFirstTime(long id, String sessionToken, int quantity) {
		ShoppingCart shoppingcart = new ShoppingCart();
		CartItem cartitem = new CartItem();
		cartitem.setQuantity(quantity);
		cartitem.setDate(new Date());
		cartitem.setPizzas(serv.select(id));
		shoppingcart.getItems().add(cartitem);
		shoppingcart.setSessionToken(sessionToken);
		return shoppingCartRepository.save(shoppingcart);
	
		
		
	}

	public ShoppingCart addtoExistingShoppingCart(long id, String sessionToken, int quantity) {
		ShoppingCart shoppingCart= shoppingCartRepository.findBySessionToken(sessionToken);
		pizzas p =serv.select(id);
		Boolean productDoesExistInTheCart = false;
		if(shoppingCart != null) {
			Set<CartItem> items =shoppingCart.getItems();
		
		       for(CartItem item : items ) {
			if(item.getPizzas()== p) {
				productDoesExistInTheCart = true;
				item.setQuantity(item.getQuantity()+quantity);
				shoppingCart.setItems(items);
				return shoppingCartRepository.saveAndFlush(shoppingCart);
			}
		}
			}
		if(!productDoesExistInTheCart && (shoppingCart != null)) {
		CartItem cartItem= new CartItem();
			cartItem.setDate(new Date());
			cartItem.setQuantity(quantity);
			cartItem.setPizzas(p);
			shoppingCart.getItems().add(cartItem);
			
			return shoppingCartRepository.saveAndFlush(shoppingCart);
	}
		return this.addShoppingCartFirstTime(id, sessionToken, quantity);
	}
	
public ShoppingCart getShoppingCartBySessionToken(String sessionToken) {
		
		return  shoppingCartRepository.findBySessionToken(sessionToken);
	}
public CartItem updateShoppingCartItem(long id, int quantity) {
	CartItem cartItem = cartItemRepository.findById(id).get();
	cartItem.setQuantity(quantity);
	return cartItemRepository.saveAndFlush(cartItem);
	
}

public ShoppingCart removeCartIemFromShoppingCart(long id, String sessionToken) {
	ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
	Set<CartItem> items = shoppingCart.getItems();
	CartItem cartItem = null;
	for(CartItem item : items) {
		if(item.getId()==id) {
			cartItem = item;
		}
	}
	items.remove(cartItem);
	cartItemRepository.delete(cartItem);
    shoppingCart.setItems(items);
    return shoppingCartRepository.save(shoppingCart);
}


}
	

