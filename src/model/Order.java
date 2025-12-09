package model;

import java.util.ArrayList;

public class Order {

	private int orderId;
	private ArrayList<OrderLine> orderLines;
	private Customer customer;

	public Order() {
		this.orderLines = new ArrayList<>();
	}

	public void addOrderLine(Product product, int quantity) {
		OrderLine line = new OrderLine(product, quantity);
		orderLines.add(line);
	}

	public void addCustomer(Customer customer) {
		this.customer = customer;
	}

	public double calculateTotal() {
		double total = 0;
		for (OrderLine line : orderLines) {
			total += line.calculateTotal();
		}
		return total;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}