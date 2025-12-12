package ui;

import java.util.Scanner;

public class MainUi {
	private static Scanner scanner;

	public MainUi() {
		MainUi.scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		MainUi ui = new MainUi();
		MainUi.openMainUi();

	}

	public static void openMainUi() {
		boolean running = true;

		while (running) {
			System.out.println("\n--- Main Menu ---");
			System.out.println("Select an option");
			System.out.println("1. Order Menu");
			System.out.println("2. Warehouse Menu");
			System.out.println("3. Exit Program");
			System.out.println("Enter choice");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				OrderUi orderUi = new OrderUi();
				orderUi.openOrderMenu();
			case 2:
				WarehouseUi warehouseUi = new WarehouseUi();
				warehouseUi.openWarehouseStatus();
				break;
			case 3:
				System.out.println("Exiting System");
				running = false;
				break;
			default:
				System.out.println("Invalid option, try again");
			}
		}

	}
}
