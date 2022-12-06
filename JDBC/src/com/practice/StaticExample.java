package com.practice;

public class StaticExample {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		
	}
	
	

}

class Student{
	static
	{
		System.out.println("this is stu class");
	}
	{
		System.out.println("in instance");
	}
}
