package com.springjdbc;

import java.util.List;

public interface DataAccessObject {
	public int insert(Product product);
	public int change(Product product);
	public int delete(int id);
	public Product getOne(int id);
	public List<Product> getAll();

}
