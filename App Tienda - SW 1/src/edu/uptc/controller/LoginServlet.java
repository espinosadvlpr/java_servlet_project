package edu.uptc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		ArrayList<User> userList;
		userList = (ArrayList<User>) request.getSession().getAttribute("userlist");
		for (User user : userList) {
			if (user.getEmail().equals(email)) {
				if (user.getPassword().equals(password)) {
					if (user.isAdmin()) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/adminMenu.jsp");
						dispatcher.forward(request, response);
					} else {
						ArrayList<String> user_data = new ArrayList<String>();
						String userdata = "Nombre del usuario: " + user.getName()+" , Direccion: "+user.getAddress();
						user_data.add(userdata);
						request.getSession().setAttribute("userdata", user_data);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/store.jsp");
						dispatcher.forward(request, response);
					}
					break;
				}
			}
		}
	}

}
