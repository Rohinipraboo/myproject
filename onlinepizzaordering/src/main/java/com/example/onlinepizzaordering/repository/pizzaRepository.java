package com.example.onlinepizzaordering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinepizzaordering.model.pizzas;

@Repository
public interface pizzaRepository extends JpaRepository<pizzas,Long>{

}
