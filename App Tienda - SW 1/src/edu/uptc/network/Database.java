package edu.uptc.network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.uptc.model.Product;
import edu.uptc.model.User;

public class Database {
	private final String database_URL = "jdbc:mysql://localhost/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String usuario = "root";
	private String clave = "12345";

	public void addUser(int id, String name, String email, String password, String address)
			throws SQLException, ClassNotFoundException {
		Statement stmt = null;
		String query = "INSERT INTO USER VALUES (" + id + ",'" + name + "','" + email + "','" + password + "','"
				+ password + "',0);";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(database_URL, this.usuario, this.clave);
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
			System.out.println("");
		} catch (SQLException sqlex) {
			throw sqlex;
		}
	}

	public void addProduct(int id, String name, int price, int quantity, String presentation)
			throws SQLException, ClassNotFoundException {
		Statement stmt = null;
		String query = "INSERT INTO PRODUCT VALUES (" + id + ",'" + name + "'," + price + "," + quantity + ",'"
				+ presentation + "');";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(database_URL, this.usuario, this.clave);
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();
			System.out.println("");
		} catch (SQLException sqlex) {
			throw sqlex;
		}
	}

	public ArrayList<User> getUsers() throws SQLException, ClassNotFoundException {
		ArrayList<User> userList = new ArrayList<User>();
		Statement stmt = null;
		String query = "select * from user;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(database_URL, this.usuario, this.clave);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id_user"));
				user.setName(rs.getString("user_name"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("user_password"));
				user.setAddress(rs.getString("user_address"));
				if (rs.getInt("admin") == 1) {
					user.setAdmin(true);
				} else {
					user.setAdmin(false);
				}
				userList.add(user);
			}
			con.close();
		} catch (SQLException sqlex) {
			throw sqlex;
		}
		return userList;
	}

	public ArrayList<Product> getProducts() throws SQLException, ClassNotFoundException {
		ArrayList<Product> productList = new ArrayList<Product>();
		Statement stmt = null;
		String query = "select * from product;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(database_URL, this.usuario, this.clave);
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Product product = new Product(rs.getInt("id_product"), rs.getString("product_name"),
						rs.getInt("product_price"), rs.getInt("product_quantity"),
						rs.getString("product_presentation"));
				productList.add(product);
			}
			con.close();
		} catch (SQLException sqlex) {
			throw sqlex;
		}
		return productList;
	}
	
	public void updateProduct(int id, int quantity) throws SQLException, ClassNotFoundException{
    	Statement stmt= null;
    	String query = "update product set product_quantity = "+quantity+" where id_product ="+id+";";
    	try{
    	    Class.forName("com.mysql.cj.jdbc.Driver");  
    	    Connection con = DriverManager.getConnection(database_URL,this.usuario,this.clave);
    	    stmt = con.createStatement();
    	    stmt.executeUpdate(query);
    	    con.close();
    	}catch(SQLException sqlex){throw sqlex;}
    }
	
}