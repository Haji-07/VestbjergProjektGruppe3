package container;

import java.util.ArrayList;

import model.Order;

public class OrderContainer {

	private static OrderContainer instance;
	private ArrayList<Order> orders;

	private OrderContainer() {
		orders = new ArrayList<>();
	}

	// Sikrer at der kun findes én instans af OrderContainer i systemet (Singleton)
	public static OrderContainer getInstance() {
		if (instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}

	public void addOrder(Order o) {
		orders.add(o);
	}

	public Order findOrderById(int id) {
		Order res = null;
		for (Order o : orders) {
			if (o.getOrderId() == id) {
				res = o;
			}
		}
		return res;
	}

}