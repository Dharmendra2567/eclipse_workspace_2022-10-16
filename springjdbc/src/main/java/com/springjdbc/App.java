package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("my programe started");
//    	ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
    	ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfiguration.class);
//    	DataAccessObject pDao = context.getBean("productDao",DataAccessObject.class);
    	ProductDao pDao = context.getBean("productDao",ProductDao.class);
    	Product product = new Product();
    
    
//////    insertng
//    product.setName("laptop");
//    product.setManufacturer("hello");
//    product.setDescription("kathmandu");
//    product.setPrice(32);
//    product.setInStock(false);
////    product.setId(9);
    //updating
    product.setName("shoes and sandles");
  product.setManufacturer("hello");
  product.setDescription("kathmandu");
  product.setPrice(32);
  product.setInStock(false);
  product.setId(10);
  int i = pDao.change(product);
//   int i=  pDao.insert(product);
//   System.out.println( "number of rows effected: "+i );
////    
////    int i =pDao.delete(1);
////    System.out.println( "number of rows effected: "+i );
    
//    Product products = pDao.getOne(7);
//    System.out.println(products);
    
//    List<Product> products = pDao.getAll();
//    for(Product p:products) {
//    System.out.println(p);
//    }
//    
    }
}
