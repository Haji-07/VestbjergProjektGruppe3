package test;

import controller.CustomerController;
import controller.OrderController;
import controller.ProductController;
import model.Person;
import model.Product;
import model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOrderController {

	@Test
	void testCreateOrder() {
		OrderController oc = new OrderController();
		oc.createOrder();
		assertEquals(0.0, oc.calculateOrderTotal());
	}

	@Test
	void testAddProduct() {
		OrderController oc = new OrderController();
		oc.createOrder();

		Product p = new Product("123", "Hammer", "En tung hammer", "Værktøj", "ModelX", "BAR123", "Reol A1", 50.0);

		new ProductController().addProduct(p);

		oc.addProductToOrder("BAR123", 2);
		assertEquals(100.0, oc.calculateOrderTotal());
	}

	@Test
	void testAddCustomer() {
		OrderController oc = new OrderController();
		oc.createOrder();

		Person person = new Person("Joe", "Joebanana boulevard 1", "9000", "12233445", "BananaJoe@gmail.com");
		Customer c = new Customer(1, person);

		new CustomerController().addCustomer(c);

		oc.addCustomerToOrder(1);
		assertEquals(0.0, oc.calculateOrderTotal());
	}

}
