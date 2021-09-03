package edu.uptc.model;

public class Bill {

	private String product;
	private String presentation;
	private int unitPrice;
	private int quantity;
	private int totalPrice;

	public Bill(String product, String presentation, int unitPrice, int quantity) {
		this.product = product;
		this.presentation = presentation;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.totalPrice = unitPrice * quantity;
	}

	public String getProduct() {
		return product;
	}

	public String getPresentation() {
		return presentation;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

}