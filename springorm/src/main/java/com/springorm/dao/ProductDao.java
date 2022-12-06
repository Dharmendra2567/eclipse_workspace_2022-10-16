package com.springorm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Product;


public class ProductDao {
	private HibernateTemplate hibernateTemplate;
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}



	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

//	inserting
	@Transactional
	public int insert(Product product) {
		int i =(Integer) hibernateTemplate.save(product);
		return i;
	}
//	getting single data
	public Product getOne(int id) {
		Product product= hibernateTemplate.get(Product.class,id);
		return product;
	}
//	selecting all data
	public List<Product> getAllData(){
		List<Product>products = hibernateTemplate.loadAll(Product.class);
		return products;
	}
//	updating data
	@Transactional
	public void updateData(Product product) {
		hibernateTemplate.update(product);
	}
	@Transactional
	public void deletaData(int id) {
		Product product= this.hibernateTemplate.get(Product.class,id);
		this.hibernateTemplate.delete(product);
	}
	

}
