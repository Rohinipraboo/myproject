package com.example.onlinepizzaordering.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ShoppingCart_id")
	private  long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Transient
	private Double totalprice;
	@Transient
	private int itemsNumber;
	
	
	@OneToMany(cascade= CascadeType.ALL,fetch = FetchType.EAGER )
	private Set<CartItem> items = new HashSet<CartItem>();
	
	
	private String sessionToken;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public ShoppingCart() {
		
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Double getTotalprice() {
		Double sum=0.0;
		for(CartItem item:this.items) {
			sum=sum + item.getPizzas().getPrice()*item.getQuantity();
		}
		
		return sum;
	}


	


	public int getItemsNumber() {
		return this.items.size();
	}


	


	public Set<CartItem> getItems() {
		return items;
	}


	public void setItems(Set<CartItem> items) {
		this.items = items;
	}


	public String getSessionToken() {
		return sessionToken;
	}


	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
