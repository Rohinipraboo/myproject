package com.example.onlinepizzaordering.model;

import java.util.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table (name="cartItem")
public class CartItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Cart_id")
	private  long id;
	private int quantity;
	 @Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "pizza_id")
	private pizzas pizzas;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ShoppingCart_id")
	private ShoppingCart shoppingCart;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public pizzas getPizzas() {
		return pizzas;
	}

	public void setPizzas(pizzas pizzas) {
		this.pizzas = pizzas;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	

}
