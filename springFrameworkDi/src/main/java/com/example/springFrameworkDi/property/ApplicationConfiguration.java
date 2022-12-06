package com.example.springFrameworkDi.property;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ="com.example.springFrameworkDi.property")
public class ApplicationConfiguration {
	@Bean(name="empdk")
	public Emp getEmp() {
		
		return new Emp();
	}
	@Bean(name="getDept")
	public Department getDepartment() {
		
		return new Department(3,"Microsoft");
	}

}
