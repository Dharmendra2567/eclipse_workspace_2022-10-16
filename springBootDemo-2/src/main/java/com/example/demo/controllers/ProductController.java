package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.entity.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@RequestMapping("")
	public String Productpage() {
		return "product";
	}
	@RequestMapping("/products/{id}")
	public String Product(@PathVariable int id, Model model) {
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product(1,"kitkat","sweet",true));
		products.add(new Product(2,"Dairy Milk","sweet",true));
		products.add(new Product(3,"star","sweet",true));
		
		Product p = new Product();
		for(int i=0;i<3;i++) {
			if(products.get(i).getId()==id) {
				p=products.get(i);
			}
		}
		model.addAttribute("product",p);
		return "product";
	}
	@GetMapping("/add")
	public String addProductForm() {
		return "addProductForm";
	}
	
	@ResponseBody
	@PostMapping("/add")
	public String addProduct(
			@RequestParam("name") String name,
			@RequestParam("manufacturer") String manufacturer,
			@RequestParam("description") String description
			) {
		return "Products "+name+"added successfully";
	}
	


}
