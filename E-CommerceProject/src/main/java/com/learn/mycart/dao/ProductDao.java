package com.learn.mycart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.learn.mycart.entities.Product;
import com.learn.mycart.entities.User;

public class ProductDao {
	
	public int addProduct(Product product) {
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int pId= (Integer) session.save(product);
		tx.commit();
		session.close();
		return pId;
		
	}
	public List<Product> getAllProduct(){
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> list = query.list();
		tx.commit();
		session.close();
		return list;
		
	}
	
	public List<Product> getAllProductBycId(int cId){
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Product as p where p.category.categoryId =: id");
		query.setParameter("id", cId);
		List<Product> list = query.list();
		tx.commit();
		session.close();
		return list;
		
	}

}
