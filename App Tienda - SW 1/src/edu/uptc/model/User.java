package edu.uptc.model;

public class User {

	private int id;
	private String name;
	private String address;
	private String email;
	private String password;
	private boolean admin;

	public User(String name, String address, String email, String password, boolean admin) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public User() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public boolean isAdmin() {
		return admin;
	}
}