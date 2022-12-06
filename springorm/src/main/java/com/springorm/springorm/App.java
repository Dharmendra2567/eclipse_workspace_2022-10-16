package com.springorm.springorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.springorm.dao.ProductDao;
import com.springorm.entities.Product;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springorm/springorm/config.xml");
		ProductDao pDao = context.getBean("productDao",ProductDao.class);

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int input;
		boolean go =true;
		while(go) {
		System.out.println("Product Menu....");
		System.out.println("PRESS 1 for insert product");
		System.out.println("PRESS 2 for view single Product");
		System.out.println("PRESS 3 for view all product");
		System.out.println("PRESS 4 for update product");
		System.out.println("PRESS 5 for delete product");
		System.out.println("PRESS 6 for EXIT");
		try {
			input = Integer.parseInt(br.readLine());
		
		switch (input) {
		case 1:
			Product product= new Product("hell","hell","hell",(float) 23.0,true);
			int i =pDao.insert(product);
			System.out.println("Done:"+i);
			
			break;
		case 2:
			System.out.println(pDao.getOne(12));
			
			break;
		case 3:
			List<Product>products = pDao.getAllData();
			for(Product p:products)
			System.out.println(p);
			
			break;
		case 4:
			Product product1= new Product(12,"hell","hell","hell",(float) 23.0,true);
			pDao.updateData(product1);
			
			break;
		case 5:
			 pDao.deletaData(12);
			System.out.println("Done");
			break;
		case 6:
			go=false;
			break;
		default:
			break;
		}
		if(go==true) {
			char ch;
			do {
				Scanner sc = new Scanner(System.in);
				System.out.println("Do you continue(y/n)");
				 ch=sc.next().charAt(0);
				 if(ch=='y') {
					 go=true;
				 }
				 else {
					 go=false;
				 }
			}while(!(ch=='y'||ch=='n'));
		}
		
		} catch(Exception e) {
			System.out.println("invalid input");
			e.printStackTrace();
		} 
		}
				
	}

}
