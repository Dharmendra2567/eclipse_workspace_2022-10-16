package webAppCRUD.model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductDao {
	
	public int save(Product p) {
	Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
	Session session = con.buildSessionFactory().openSession();
	Transaction tx = session.beginTransaction();
	int i = (Integer) session.save(p);
	tx.commit();
	session.close();
	return i;
	}
	
	public ArrayList<Product> getAll() {
		Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
		Session session = con.buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		ArrayList<Product> products = (ArrayList<Product>) session
				.createQuery("SELECT a FROM Product a", Product.class)
				.getResultList();
		tx.commit();
		session.close();
		return products;
		
		
	}

	public static Product getOne(int id) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
		Session session = con.buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		 Product product =  session.find(Product.class,id);	
		tx.commit();
		session.close();
		return product;
	
	}
	public void update(Product p) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
		Session session = con.buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		 session.update(p);
		tx.commit();
		session.close();
		}

	public void delete(int id) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
		Session session = con.buildSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Product p = session.get(Product.class,id);
		 session.delete(p);
		tx.commit();
		session.close();
		
		
	}


}
