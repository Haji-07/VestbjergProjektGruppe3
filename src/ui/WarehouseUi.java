package ui;

import controller.ProductController;
import model.Product;

import java.util.Scanner;

public class WarehouseUi {
	private ProductController productCtrl;
	private Scanner scanner;

	public WarehouseUi() {
		this.productCtrl = new ProductController();
		this.scanner = new Scanner(System.in);

	}

	public void openWarehouseStatus() {
		boolean running = true;

		System.out.println("---Warehouse Status---");

		while (running) {
			System.out.println("\nSelect an option");
			System.out.println("1. Find Product");
			System.out.println("2. Exit");
			System.out.println("Enter choice");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				findProductDetails();
				break;
			case 2:
				running = false;
				exitWarehouse();
				break;
			default:
				System.out.println("Invalid option, try again");
			}

		}
	}

	public void findProductDetails() {
		System.out.println("Enter Product Barcode/ID");
		String barcode = scanner.nextLine();
		Product foundProduct = productCtrl.findProductByBarcode(barcode);
		if(foundProduct == null) {
			System.out.println("No product found with that Barcode");
			System.out.println("Enter Product ID to search instead");
			String productId = scanner.nextLine();
			foundProduct = productCtrl.findProductByProductId(productId);
		}
		showProductDetails(foundProduct);
	}
	public void showProductDetails(Product product) {
		if (product != null) {
			System.out.println("Showing product details for " + product.getName());
		}else {
			System.out.println("Product couldn't be found");
		}
	}
	public void exitWarehouse() {
		System.out.println("Closing Warehouse Status");
	}

}
