package com.learn.mycart.servlets;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learn.mycart.entities.User;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("registerForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			User user = new User(
					request.getParameter("userName"),
					request.getParameter("userAddress"),
					request.getParameter("userEmail"),
					request.getParameter("userPassword"),
					request.getParameter("userPhone"),
					request.getParameter("userPic"),
					"admin"
					);
			Configuration con = new Configuration().configure().addAnnotatedClass(User.class);
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			int i=(Integer) session.save(user);
			tx.commit();
			session.close();
			
			HttpSession httpsession = request.getSession();
			httpsession.setAttribute("message", "Registration successful");
			response.sendRedirect("register");
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
