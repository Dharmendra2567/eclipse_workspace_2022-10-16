package com.learn.mycart.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


import com.learn.mycart.dao.CategoryDao;
import com.learn.mycart.dao.ProductDao;
import com.learn.mycart.entities.Category;
import com.learn.mycart.entities.Product;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig
public class ProductOperationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("operation");
		if(op.trim().equals("addCategory")) {
			
			String title = request.getParameter("category_title");
			String description = request.getParameter("category_description");
			Category category = new Category();
			category.setCategoryTitle(title);
			category.setCategoryDescription(description);
			CategoryDao catDao = new CategoryDao();
			catDao.addCategory(category);
			HttpSession httpsession =request.getSession();
			httpsession.setAttribute("message", "category added successfully");
			response.sendRedirect("/E-CommerceProject/admin.jsp");
			return ;
		}
		else if(op.trim().equals("addProduct")) {
			
			String pName = request.getParameter("product_name");
			int pPrice = Integer.parseInt(request.getParameter("product_price"));
			int pDiscount = Integer.parseInt(request.getParameter("product_discount"));
			int pQuantity = Integer.parseInt(request.getParameter("product_quantity"));
			String pDescription = request.getParameter("product_description");
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			Part part = request.getPart("product_pic");
			
			Product p = new Product();
			p.setpName(pName);
 			p.setpDescription(pDescription);
			p.setpPrice(pPrice);
			p.setpDiscount(pDiscount);
			p.setpQuantity(pQuantity);
			p.setpPhoto(part.getSubmittedFileName());
			CategoryDao cDao = new CategoryDao();
			Category catid =cDao.getCategory(categoryId);
			p.setCategory(catid);
			
			ProductDao pDao = new ProductDao();
			pDao.addProduct(p);
			try {
				String fileName = part.getSubmittedFileName();
				String uploadPath = "C:/Users/DELL/eclipse-workspace10-16/E-CommerceProject/src/main/webapp/image/products/"+fileName;
				FileOutputStream fos = new FileOutputStream(uploadPath);
				InputStream is = part.getInputStream();
				byte [] data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
				HttpSession httpsession = request.getSession();
				httpsession.setAttribute("message","product added successfully");
				response.sendRedirect("/E-CommerceProject/admin.jsp");
				return;
		}
	}

}
