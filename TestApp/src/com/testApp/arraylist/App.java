package com.testApp.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Employee e = getEmployee();
//		ArrayList<Employee> emp= new ArrayList<>();
//		emp.add(e);
//		System.out.println(emp);
		System.out.println(e);		
	
	}
	public static Employee getEmployee() {
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		System.out.println("enter employee id");
		employee.setId(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter employee's name");
		employee.setName(sc.nextLine());
		System.out.println("enter employee's salary");
		employee.setSalary(sc.nextInt());
		return employee;
		
	}
}

