package controller;

import container.OrderContainer;
import model.Discount;
import model.DiscountType;
import model.Order;
import model.Product;
import model.Customer;

public class OrderController {

	private OrderContainer orderContainer;
	private ProductController productController;
	private CustomerController customerController;
	private Order o;

	public OrderController() {
		orderContainer = OrderContainer.getInstance();
		productController = new ProductController();
		customerController = new CustomerController();
	}

	public void createOrder() {
		o = new Order();
	}

	public void addProductToOrder(String barcode, int quantity) {
		Product p = productController.findProductByBarcode(barcode);
		if (o != null && p != null) {
			o.addOrderLine(p, quantity);
		}
	}

	public void addCustomerToOrder(int customerId) {
		Customer c = customerController.findCustomerById(customerId);
		if (o != null && c != null) {
			o.addCustomer(c);
		}
	}

	public void addCraftsmanDiscount() {
		if (o != null) {
			o.addDiscount(new Discount(DiscountType.CRAFTSMAN, 10));
		}
	}

	public void addPickupDiscount() {
		if (o != null) {
			o.addDiscount(new Discount(DiscountType.PICKUP, 5));
		}
	}

	public void addQuantityDiscount(int totalQuantity) {
		if (o != null && totalQuantity >= 10) {
			o.addDiscount(new Discount(DiscountType.QUANTITY, 5));
		}
	}

	public double calculateOrderTotal() {
		double total = 0.0;
		if (o != null) {
			total = o.calculateTotal();
		}
		return total;
	}

	public void saveOrder() {
		if (o != null) {
			orderContainer.addOrder(o);
		}
	}

	public void finishOrder() {
		saveOrder();
	}
	
	public Order getCurrentOrder() {
		return o;
	}

}