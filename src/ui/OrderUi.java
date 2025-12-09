package ui;

import controller.OrderController;

public class OrderUi {
	private OrderController orderCtrl;

	public OrderUi() {
		this.orderCtrl = new OrderController();
	}

	public void createOrder() {
		
	}

	public void start() {
		System.out.println("Starting Order System...");
	}

	public static void main(String[] args) {
		OrderUi ui = new OrderUi();
		ui.start();
	}
}
