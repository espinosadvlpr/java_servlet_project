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
import edu.uptc.model.User;


/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Manager manager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User(name, address, email, password,false);
		ArrayList<User> userList;
		userList = (ArrayList<User>) request.getSession().getAttribute("userlist");
		if (userList!=null ) {
			int id = userList.size()+1;
			user.setId(id);
			userList.add(user);
		}else{
			userList = new ArrayList<User>();
			user.setId(1);
			userList.add(user);
		}
		try {
			manager.addUser(user.getId(), name, email, password, address);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("userlist", userList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
        dispatcher.forward(request, response);
	}

}
