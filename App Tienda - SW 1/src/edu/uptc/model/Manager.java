package edu.uptc.model;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.uptc.network.Database;


public class Manager {
	Database db = new Database();

	public Manager() {
		
	}   
	
	public void addUser(int id, String name, String email, String password, String address) throws ClassNotFoundException, SQLException{
		db.addUser(id, name, email, password, address); 
	}
	
	public void addProduct(int id, String name, int price, int quantity, String presentation) throws ClassNotFoundException, SQLException{
		db.addProduct(id, name, price, quantity, presentation); 
	}
	
	public ArrayList<User> getUsers() throws ClassNotFoundException, SQLException {
		return db.getUsers();
	}
	
	public ArrayList<Product> getProducts() throws ClassNotFoundException, SQLException {
		return db.getProducts();
	}
	
	public void updateProduct(int id, int quantity) throws ClassNotFoundException, SQLException {
		db.updateProduct(id, quantity); 
	}
}