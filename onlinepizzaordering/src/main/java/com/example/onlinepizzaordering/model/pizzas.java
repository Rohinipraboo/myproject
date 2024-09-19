package com.example.onlinepizzaordering.model;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pizzas")
public class pizzas {
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "pizza_id")
	  private long pizzaId;

	 @Lob
	  @Column(name = "image",length=1000)
	  private String file;
	  @Column(name = "pizza_name")
	  private String pname;
	  
	  private String descp;
	  
	  private int price;

	  

	@OneToMany(cascade= CascadeType.ALL )
		private Collection<CartItem> items;
		

		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "customer_id")
		private Customer customer;
	  
	  public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public String getDescp() {
			return descp;
		}

		public void setDescp(String descp) {
			this.descp = descp;
		}

	public Collection<CartItem> getItems() {
		return items;
	}

	public void setItems(Collection<CartItem> items) {
		this.items = items;
	}

	public pizzas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public pizzas(long pizzaId, String file, String pname, int price, String descp) {
		super();
		this.pizzaId = pizzaId;
		this.file = file;
		this.pname = pname;
		this.price = price;
		this.descp= descp;
	}

	public long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(long pizzaId) {
		this.pizzaId = pizzaId;
	}

	

	

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) { 
		this.price = price;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	
	
	 

}
