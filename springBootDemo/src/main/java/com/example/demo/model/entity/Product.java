package com.example.demo.model.entity;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="product_7am")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String manufacturer;
	private String description;
	private BigDecimal price;
	private int quantity;
	private boolean Active;
	private String imageURL;
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	private Date dateUpdated;
	@ManyToOne
	private Category category;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(Long id, String name, String manufacturer, String description, BigDecimal price, int quantity,
			boolean active, String imageURL, Date createdDate, Date dateUpdated, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		Active = active;
		this.imageURL = imageURL;
		this.createdDate = createdDate;
		this.dateUpdated = dateUpdated;
		this.category = category;
	}
	

	public Product(String name, String manufacturer, String description, BigDecimal price, int quantity, boolean active,
			String imageURL, Date createdDate, Date dateUpdated, Category category) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		Active = active;
		this.imageURL = imageURL;
		this.createdDate = createdDate;
		this.dateUpdated = dateUpdated;
		this.category = category;
	}
	
	

	
	public Product(Long id, String name, String manufacturer, String description, BigDecimal price, int quantity,Category category, boolean active) {
		super();
		this.id=id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		Active = active;
//		this.imageURL = imageURL;
	}
	public Product( String name, String manufacturer, String description, BigDecimal price, int quantity,Category category, boolean active) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		Active = active;
//		this.imageURL = imageURL;
	}

	public Product(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL( String imageURL) {
		this.imageURL = imageURL;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", description="
				+ description + ", price=" + price + ", quantity=" + quantity + ", Active=" + Active + ", imageURL="
				+ imageURL + ", createdDate=" + createdDate + ", dateUpdated=" + dateUpdated + ", category=" + category
				+ "]";
	}
	
	
}

