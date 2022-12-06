package com.example.demo.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductRepository productRepo;
	@Autowired
	CategoryRepository categoryRepo;
	
	@RequestMapping("")
	public String Productpage(Model model) {
		List<Product> products = productRepo.findAll();
		model.addAttribute("products", products);
		Category category = new Category();
//		Long id=category.getId();
//		Optional<Category> categories =  categoryRepo.findById(id);
		model.addAttribute("categories",categoryRepo.findById(category.getId()));
		return "product";
	}
	@RequestMapping("/products/{id}")
	public String Product(@PathVariable int id, Model model) {
		ArrayList<Product> products = new ArrayList<>();
//		products.add(new Product(1,"kitkat","sweet",true));
//		products.add(new Product(2,"Dairy Milk","sweet",true));
//		products.add(new Product(3,"star","sweet",true));
//		
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
	public String addProductForm(Model model) {
		List<Category> categories = categoryRepo.findAll();
		model.addAttribute("categories",categories);
		return "addProductForm";
	}
	
	
//	@ResponseBody
//	@PostMapping("/add")
//	public String addProduct(
//			@RequestParam("name") String name,
//			@RequestParam("manufacturer") String manufacturer,
//			@RequestParam("description") String description
//			) {
//		return "Products "+name+"added successfully";
//	@ResponseBody
//	@PostMapping("/add")
//	public String addProduct(@ModelAttribute Product product, @RequestParam("image") MultipartFile image) {
//	return product.toString();
//	}

//	@ResponseBody
	@PostMapping("/add")
	public RedirectView addProduct( 
			Model model,
			@ModelAttribute Product product,
			@RequestParam("name") String name,
			@RequestParam("manufacturer") String manufacturer,
			@RequestParam("description") String description,
			@RequestParam("price") BigDecimal price,
			@RequestParam("quantity") int quantity,
			@RequestParam("category") Category category,
			@RequestParam("active") boolean active
			) {
		Product product1 = new Product(name,manufacturer,description,price,quantity,category,active);
		productRepo.save(product1);
		model.addAttribute("products",product1);
		RedirectView rv = new RedirectView();
		String url="http://localhost:8080/products";
		rv.setUrl(url);
		return rv;
	}
	//update product form
	@RequestMapping("/update/{id}")
	public String updateProductForm(@PathVariable Long id, Model model) {
		Product product = productRepo.findById(id).get();
		productRepo.save(product);
		List<Category> cat = categoryRepo.findAll();
		model.addAttribute("categories",cat);
		model.addAttribute("p", product);
		System.out.println(product);
		return "updateProductForm";
	}
	@PostMapping("/update/{id}")
	public RedirectView updateProduct( 
			Model model,
			@ModelAttribute Product product,
			@RequestParam("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("manufacturer") String manufacturer,
			@RequestParam("description") String description,
			@RequestParam("price") BigDecimal price,
			@RequestParam("quantity") int quantity,
			@RequestParam("category") Category category,
			@RequestParam("active") boolean active
			) {
		Product product1 = new Product(id,name,manufacturer,description,price,quantity,category,active);
		productRepo.save(product1);
		model.addAttribute("products",product1);
		RedirectView rv = new RedirectView();
		String url="http://localhost:8080/products";
		rv.setUrl(url);
		return rv;
	}
	//delete product
	@RequestMapping("/delete/{id}")
	public RedirectView deleteProduct(
			Model model,
			@ModelAttribute Product product,
			@PathVariable Long id
//			@RequestParam("id") Long id
			){
		Product product1 = new Product(id);
		productRepo.delete(product1);
		RedirectView rv = new RedirectView();
		String url="http://localhost:8080/products";
		rv.setUrl(url);
		return rv;
	}
	
}

