package com.learn.mycart.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.learn.mycart.entities.User;

public class UserDao {
	
	
	public User getUserByEmailandPassword(String email, String password) {
//		User user=null;
//		try {
			String query = "from User where userEmail=:e and userPassword=:p";
			Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();
			Query q = session.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);
			User user= (User) q.uniqueResult();
			session.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return user;
		
	}

}
