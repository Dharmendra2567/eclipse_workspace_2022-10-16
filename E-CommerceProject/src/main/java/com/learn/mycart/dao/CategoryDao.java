package com.learn.mycart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.learn.mycart.entities.Category;
import com.learn.mycart.entities.User;

public class CategoryDao {
	public int addCategory(Category category) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		int catId= (Integer) session.save(category);
		tx.commit();
		session.close();
		return catId;
		
	}
	public List<Category> getCategories(){
		
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Category");
		List<Category> list = query.list();
		tx.commit();
		session.close();
		return list;
	}
	public Category getCategory(int cId) {
		Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Category catid= session.get(Category.class,cId);
		tx.commit();
		session.close();
		return catid;
	}

}
