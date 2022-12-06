package com.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt(1));
		product.setName(rs.getString(2));
		product.setManufacturer(rs.getString(3));
		product.setDescription(rs.getString(4));
		product.setPrice(rs.getFloat(5));
		product.setInStock(rs.getBoolean(6));
		return product;
	}

}
