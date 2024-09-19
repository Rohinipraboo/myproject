package com.example.onlinepizzaordering.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer
{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "customer_id")
  private Long customerId;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email_address")
  private String emailAddress;
  
  private String password;
  
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
  private Set<pizzas> pizzas;
  

  

  public Set<pizzas> getPizzas() {
	return pizzas;
}

public void setPizzas(Set<pizzas> pizzas) {
	this.pizzas = pizzas;
}

public Customer() {}
  
  public Customer(Customer customer)
  {
    this.customerId = customer.getCustomerId();
    this.firstName = customer.getFirstName();
    this.lastName = customer.getLastName();
    this.emailAddress = customer.getEmailAddress();
    this.password = customer.getPassword();
   
   
  }

  public Long getCustomerId()
  {
    return customerId;
  }

  public void setCustomerId(Long customerId)
  {
    this.customerId = customerId;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getEmailAddress()
  {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress)
  {
    this.emailAddress = emailAddress;
  }

  

 

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }
}