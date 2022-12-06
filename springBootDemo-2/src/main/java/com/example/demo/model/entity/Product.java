package com.example.demo.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Product {
	private Long id;
	private String name;
	private String manufacturer;
	private String description;
	private BigDecimal price;
	private int quantity;
	private String imageURL;
	private Date dateCreated;
	private Date dateUpdated;
	private boolean Active;
}