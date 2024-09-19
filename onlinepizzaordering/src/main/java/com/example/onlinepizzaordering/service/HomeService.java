package com.example.onlinepizzaordering.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.onlinepizzaordering.model.pizzas;
import com.example.onlinepizzaordering.repository.pizzaRepository;


@Service
public class HomeService {

	@Autowired
	 private pizzaRepository pdtrepo;
	
	public void addprd(String pname, MultipartFile file, int price,String descp) {
		pizzas p = new pizzas();
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		if(filename.contains(".."))
		{
			System.out.println("not a validfile");
		}
		try {
			p.setFile(Base64.getEncoder().encodeToString(file.getBytes()));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		p.setPname(pname);
		p.setPrice(price);
		p.setDescp(descp);
		
		pdtrepo.save(p);
		
		
	}
	public pizzas select(long id) {
		return pdtrepo.findById(id).get();
		
	}
	
	public void editpizza(String pname, MultipartFile file, int price, long pizzaId, String descp) {
		pizzas p = new pizzas();
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		if(filename.contains(".."))
		{
			System.out.println("not a validfile");
		}
		try {
			p.setFile(Base64.getEncoder().encodeToString(file.getBytes()));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		p.setPizzaId(pizzaId);
		p.setPname(pname);
		p.setPrice(price);
		p.setDescp(descp);
		
		pdtrepo.save(p);
		
		
	}
	

	

	
}
