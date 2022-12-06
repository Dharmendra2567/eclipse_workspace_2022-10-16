package com.learn.mycart.servlets;

import java.io.IOException;

import com.learn.mycart.dao.UserDao;
import com.learn.mycart.entities.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("loginForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao userdao = new UserDao();
		User user =userdao.getUserByEmailandPassword(email,password);
		System.out.println(user);
		 
		HttpSession session = request.getSession();
		if(user==null) {
		session.setAttribute("errormessage", "Invalid username or password");
		}
		else {
			session.setAttribute("message", "Welcome "+user.getUserName());
		}
//		response.sendRedirect("loginForm.jsp");
		session.setAttribute("current-user", user);
		if(user.getUserType().equalsIgnoreCase("admin")) {
			response.sendRedirect("admin.jsp");
		}
		else if(user.getUserType().equalsIgnoreCase("normal")) {
			response.sendRedirect("normal.jsp");
		}
		return;
	}

}
