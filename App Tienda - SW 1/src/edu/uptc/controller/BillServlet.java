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

import edu.uptc.model.Bill;
import edu.uptc.model.Manager;
import edu.uptc.model.Product;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Manager manager;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillServlet() {
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
		ArrayList<Bill> billList;
		billList = (ArrayList<Bill>) request.getSession().getAttribute("billList");
		ArrayList<Product> productList;
		productList = (ArrayList<Product>) request.getSession().getAttribute("productlist");
		for (Bill bill : billList) {
			for (Product product : productList) {
				if (product.getProduct().equals(bill.getProduct()) && product.getPresentation().equals(bill.getPresentation())) {
					try {
						manager.updateProduct(product.getId(), (product.getQuantity()-bill.getQuantity()));
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		try {
			ArrayList<Product> productListUpdate = manager.getProducts();
			request.getSession().setAttribute("productlist", productListUpdate);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sale.jsp");
        dispatcher.forward(request, response);
	}

}
