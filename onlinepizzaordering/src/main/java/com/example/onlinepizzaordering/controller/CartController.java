package com.example.onlinepizzaordering.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.onlinepizzaordering.model.ShoppingCart;
import com.example.onlinepizzaordering.service.ShoppingCartService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	
	@PostMapping("/addtocart")
	public String addtocart(HttpSession session , Model model,@RequestParam("pizzaId") long id,@RequestParam("quantity") int quantity){
		
		String sessionToken =(String) session.getAttribute("sessionToken");
		if(sessionToken ==null) {
			sessionToken = UUID.randomUUID().toString();
			session.setAttribute("sessionToken",sessionToken);
			shoppingCartService.addShoppingCartFirstTime(id,sessionToken,quantity);
			
		}
		else {
			shoppingCartService.addtoExistingShoppingCart(id,sessionToken,quantity);
		}
		
		return "redirect:/prdlist";
	}
	@GetMapping("/Shoppingcart")
	public String showShoppingCartView(HttpServletRequest request,Model model) {
		String sessionToken =(String) request.getSession(true).getAttribute("sessionToken");
if(sessionToken == null) {
	model.addAttribute("shoppingCart", new ShoppingCart());

}
else {
	ShoppingCart shoppingCart = shoppingCartService.getShoppingCartBySessionToken(sessionToken);
	model.addAttribute("shoppingCart", shoppingCart);
}

		return "cart";
	}
	@PostMapping("/updateShoppingCart")
	public String updateCartItem(@RequestParam("id") Long id,
			@RequestParam("quantity") int quantity) {
		
		shoppingCartService.updateShoppingCartItem(id,quantity);
		return "redirect:Shoppingcart";
	}
	
	@GetMapping("/removeCartItem/{id}")
	public String removeItem(@PathVariable long id, HttpServletRequest request) {
		HttpSession session=request.getSession(false);  
        String sessionToken =(String)session.getAttribute("sessionToken"); 
		
		shoppingCartService.removeCartIemFromShoppingCart(id,sessionToken);
		return "redirect:/Shoppingcart";
	}
	@RequestMapping("/")
	public String getaddress(){
		return "placingorder";
	}
	@RequestMapping("/confirmorder")
	public String confirmorder(){
		return "confirm order";
	}
	}
	

	
	

