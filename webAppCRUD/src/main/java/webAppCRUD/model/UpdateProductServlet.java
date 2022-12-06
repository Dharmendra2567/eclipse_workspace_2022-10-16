package webAppCRUD.model;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	new ProductDao();
	Product p =ProductDao.getOne(id);
	request.setAttribute("product", p);
	request.getRequestDispatcher("updateProductForm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p = new Product(
				Integer.parseInt(request.getParameter("id")),
				request.getParameter("name"),
				request.getParameter("manufacturer"),
				request.getParameter("description"),
				Float.parseFloat(request.getParameter("price")),
				request.getParameter("inStock").equalsIgnoreCase("true")?true:false
				);
		ProductDao pDao = new ProductDao();
		pDao.update(p);
		response.sendRedirect("product");
		
		
	}

}
