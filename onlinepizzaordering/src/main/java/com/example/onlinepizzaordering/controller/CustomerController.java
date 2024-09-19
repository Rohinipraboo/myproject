package com.example.onlinepizzaordering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.onlinepizzaordering.model.Customer;
import com.example.onlinepizzaordering.repository.HomeRepo;
@Controller
public class CustomerController {
@Autowired
private HomeRepo homeRepo;
	
	
	@GetMapping("/customerlogin")
	  public  static String customers()
	  {
	    
	    return "customers";
	  }
	@PostMapping("saveCustomerdetails")
	public String get(@ModelAttribute Customer customer) {
		homeRepo.save(customer);
		return  "customers";
	}
	
}
