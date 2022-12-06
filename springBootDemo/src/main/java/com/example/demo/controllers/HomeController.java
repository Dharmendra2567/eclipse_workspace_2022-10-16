package com.example.demo.controllers;

import com.example.demo.model.entity.*;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String Homepage() {
		return "homepage";
	}
	@RequestMapping("/products/{id}")
	public String Product(@PathVariable int id, Model model) {
		ArrayList<Product> products = new ArrayList<>();
//		products.add(new Product(1,"kitkat","sweet",true));
//		products.add(new Product(2,"Dairy Milk","sweet",true));
//		products.add(new Product(3,"star","sweet",true));
		
		Product p = new Product();
		for(int i=0;i<3;i++) {
			if(products.get(i).getId()==id) {
				p=products.get(i);
			}
		}
		model.addAttribute("product",p);
		return "product";
	}

}
