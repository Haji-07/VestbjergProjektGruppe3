package ui;

import controller.OrderController;
import model.Order;
import model.OrderLine;
import model.Product;
import java.util.Scanner;

public class OrderUi {
	private OrderController orderCtrl;
	private Scanner scanner;

	public OrderUi() {
		this.orderCtrl = new OrderController();
		this.scanner = new Scanner(System.in);
	}

	public void openOrderMenu() {
		boolean running = true;

		System.out.println("--- Order Menu ---");
		createOrder();

		while (running) {
			System.out.println("\nSelect an option:");
			System.out.println("1. Add Customer");
			System.out.println("2. Add Product");
			System.out.println("3. Show Total");
			System.out.println("4. Finish Order");
			System.out.print("Enter choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addCustomerToOrder();
				break;

			case 2:
				addProductToOrder();
				break;

			case 3:
				showOrderTotal();
				break;

			case 4:
				finishOrderMenu();
				running = false;
				break;

			default:
				System.out.println("Invalid option, try again.");
			}
		}
	}

	private void createOrder() {
		System.out.println("Initializing new order...");
		orderCtrl.createOrder();
	}

	private void addCustomerToOrder() {
		System.out.print("Enter Customer ID: ");
		int customerId = scanner.nextInt();
		scanner.nextLine();

		orderCtrl.addCustomerToOrder(customerId);
		System.out.println("Customer added.");
	}

	private void addProductToOrder() {
		System.out.print("Enter Product Barcode: ");
		String barcode = scanner.nextLine();

		System.out.print("Enter Quantity: ");
		int quantity = scanner.nextInt();
		scanner.nextLine();

		orderCtrl.addProductToOrder(barcode, quantity);
		System.out.println("Product added to order.");

	}

	public void showOrderTotal() {
		double total = orderCtrl.calculateOrderTotal();
		System.out.println("Total Price: kr" + total);
	}

	public void finishOrderMenu() {
		System.out.println("Finalizing order...");
		orderCtrl.finishOrder();
		System.out.println("Order completed and saved.");
	}
}
