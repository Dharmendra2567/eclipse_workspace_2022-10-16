package webAppCRUD.model;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class AddProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addProductForm.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Product p = new Product(
			
			0,
			request.getParameter("name"),
			request.getParameter("manufacturer"),
			request.getParameter("description"),
			Float.parseFloat(request.getParameter("price")),
			request.getParameter("inStock").equalsIgnoreCase("true")?true:false
			);
	ProductDao pDao = new ProductDao();
	pDao.save(p);
	response.sendRedirect("product");
	
	}

}
