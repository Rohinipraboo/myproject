package com.example.onlinepizzaordering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.onlinepizzaordering.model.pizzas;
import com.example.onlinepizzaordering.repository.pizzaRepository;
import com.example.onlinepizzaordering.service.HomeService;

@Controller
public class productController {
	
	@Autowired
	private HomeService serv;
     @Autowired
private pizzaRepository pdtrepo;

	
	@GetMapping("/addprd")
	public static String login2() {
		return "addprds";
	}
	@PostMapping("/addpizzas")
	public String addbagprds(@RequestParam("pname") String pname,@RequestParam("file") MultipartFile file,@RequestParam("descp") String descp,@RequestParam("price") int price) {
		serv.addprd(pname,file,price,descp);
		return "redirect:/prdlist";
		
	}
	@GetMapping("prdlist")
	public String pdtlist(Model model) {
		List<pizzas> list=pdtrepo.findAll();
		model.addAttribute("products",list);
	return "index";
		
	}
	@RequestMapping("/prdlist/{id}")
	public ModelAndView select(@PathVariable("id") long id,Model model) {
		pizzas m = serv.select(id);
//		model.addAttribute("select",m);
//		return "selectedid";
		return new ModelAndView("selectedid","select",m);	
}
	@PostMapping("/editpizza")
	public String addbagprds(@RequestParam("pizzaId") long pizzaId, @RequestParam("pname") String pname,@RequestParam("file") MultipartFile file,@RequestParam("price") int price,@RequestParam("descp") String descp) {
		serv.editpizza(pname,file,price,pizzaId,descp);
		return "redirect:/prdlist" ;
		
	}
	@RequestMapping("/Deleteproduct/{id}")
	public String deletepdt(@PathVariable("id") long id,Model model) {
		pdtrepo.deleteById(id);
		return  "redirect:/prdlist";
	}
	
	
	
	
}
