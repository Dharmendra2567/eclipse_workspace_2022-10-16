package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.entity.Category;
import com.example.demo.repositories.CategoryRepository;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryRepository CategoryRepo;
	
	@RequestMapping()
	public String Categories() {
		return "categories/categories";
	}
	@GetMapping("/add")
	public String categoryForm() {
		return "categories/addCategoryForm";
	}
	@PostMapping("/add")
	public String addCategoryForm(
			@RequestParam("name") String name,
			@RequestParam("description") String description
			) {
		Category category = new Category(name,description);
		CategoryRepo.save(category);
		return "redirect:/categories";
	}

}
