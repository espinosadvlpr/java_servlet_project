package edu.uptc.model;

public class Product {
	private int id;
	private String name;
	private int price;
	private int quantity;
	private String presentation;

	public Product(int id, String name, int price, int quantity, String presentation) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.presentation = presentation;
	}

	public int getId() {
		return id;
	}

	public String getProduct() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getPresentation() {
		return presentation;
	}

}