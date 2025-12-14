package model;

import java.util.ArrayList;

public class Order {

	private ArrayList<OrderLine> orderLines;
	private ArrayList<Discount> discounts;
	private Customer customer;
	private OrderStatus status;

	private static double MAX_DISCOUNT = 20.0;

	public Order() {
		this.orderLines = new ArrayList<>();
		this.discounts = new ArrayList<>();
		this.customer = null;
		this.status = OrderStatus.ACTIVE;

	}

	public void addOrderLine(Product product, int quantity) {
		OrderLine line = new OrderLine(product, quantity);
		orderLines.add(line);
	}

	public void addCustomer(Customer customer) {
		this.customer = customer;
	}

	public void addDiscount(Discount discount) {
		discounts.add(discount);
	}

	public double calculateTotal() {
	    double total = 0.0;
	    for (OrderLine line : orderLines) {
	        total += line.getProduct().getPrice() * line.getQuantity();
	    }

	    // calculate total discount percentage
	    double discountPercentage = 0.0;
	    for (Discount d : discounts) {
	        discountPercentage += d.getPercentage();
	    }
	    // cap max discount at 20%
	    if (discountPercentage > MAX_DISCOUNT) {
	        discountPercentage = MAX_DISCOUNT;
	    }

	    // apply discount
	    return total * (1 - discountPercentage / 100);
	}


	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
}