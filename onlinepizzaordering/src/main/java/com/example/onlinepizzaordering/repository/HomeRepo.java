package com.example.onlinepizzaordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinepizzaordering.model.Customer;

@Repository
public interface HomeRepo extends JpaRepository<Customer,Integer>{

	

}
