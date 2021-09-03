package edu.uptc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.Manager;
import edu.uptc.model.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Manager manager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (manager == null) {
			manager = new Manager();
		}
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("product");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String presentation = request.getParameter("presentation");
		Product product = new Product(id, name, price, quantity, presentation);
		ArrayList<Product> productList;
		productList = (ArrayList<Product>) request.getSession().getAttribute("productlist");
		if (productList!=null ) {
			productList.add(product);
		}else{
			productList = new ArrayList<Product>();
			productList.add(product);
		}
		try {
			manager.addProduct(id, name, price, quantity, presentation); 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("productlist", productList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
        dispatcher.forward(request, response);
	}

}
