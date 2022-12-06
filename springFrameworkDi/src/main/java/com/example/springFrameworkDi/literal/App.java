package com.example.springFrameworkDi.literal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context =new  ClassPathXmlApplicationContext("com/example/springFrameworkDi/literal/Beans.xml");
		Course javacourse = context.getBean("javaCourse",Course.class);
		System.out.println(javacourse);
		System.out.println("hello world again");
	}

}
