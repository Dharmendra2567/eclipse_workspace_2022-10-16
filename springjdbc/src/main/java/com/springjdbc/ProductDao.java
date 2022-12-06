package com.springjdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("productDao")
public class ProductDao implements DataAccessObject {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Product product) {
		String query ="insert into product(name,manufacturer,description,price,inStock) values(?,?,?,?,?)";
		int i =jdbcTemplate.update(query,product.getName(),product.getManufacturer(),product.getDescription(),product.getPrice(),product.isInStock());
		return i;
	}

	public int change(Product product) {
		String query="update product set name=?,manufacturer=?,description=?,price=?,inStock=? where id=?";
		int i = jdbcTemplate.update(query,product.getName(),product.getManufacturer(),product.getDescription(),product.getPrice(),product.isInStock(),product.getId());
		return i;
	}

	public int delete(int id) { 
		String query="delete from product where id=?";
		int i =jdbcTemplate.update(query,id);
		return i;
	}

	public Product getOne(int id) {
		String query = "select *from product where id=?";
		RowMapper<Product> rowMapper = new RowMapperImpl();
		Product p =jdbcTemplate.queryForObject(query, rowMapper,id);
		return p;
	}

	public List<Product> getAll() {
		String query = "select *from product";
		List<Product> p = jdbcTemplate.query(query,new RowMapperImpl());
		return p;
	}

	
}
