package com.example.springFrameworkDi.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("employee")
public class Emp {
	@Value("3")
	private int id;
	@Value("shah")
	private String name;
	@Autowired
	@Qualifier("department")
	private Department department;
	
	
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", department=" + department + "]";
	}
	
	
	
	
	

}
