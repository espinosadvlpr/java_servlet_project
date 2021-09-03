package edu.uptc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.Bill;
import edu.uptc.model.Product;

/**
 * Servlet implementation class StoreServlet
 */
@WebServlet("/StoreServlet")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreServlet() {
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
		ArrayList<Product> productList;
		productList = (ArrayList<Product>) request.getSession().getAttribute("productlist");
		
		String [] selectedProductIndexes = request.getParameterValues("selected");
		if (selectedProductIndexes != null) {
			ArrayList<Bill> billList = new ArrayList<Bill>();
			for (int i = 0; i < selectedProductIndexes.length; i++) {
				Product product = (productList.get(Integer.parseInt(selectedProductIndexes[i])-1));
				billList.add(new Bill(product.getProduct(), product.getPresentation(), product.getPrice(), Integer.parseInt(request.getParameter(""+product.getId()+""))));
			}
			int subtotal = 0;
			for (Bill bill : billList) {
				subtotal +=bill.getTotalPrice();
			}
			int total = (int) (subtotal + (subtotal*0.19));
			request.setAttribute("subtotal", subtotal);
			request.setAttribute("total", total);
			request.getSession().setAttribute("billList", billList);
			request.setAttribute("bill_id", (int)(Math.floor(Math.random()*(99999-10000+1)+10000)) );
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bill.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
