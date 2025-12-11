package controller;

import container.CustomerContainer;
import model.Customer;
import model.Person;
import model.Business;

public class CustomerController {

	private CustomerContainer customerContainer;
	private int nextCustomerId;

	public CustomerController() {
		customerContainer = CustomerContainer.getInstance();
		nextCustomerId = 1;
	}

	private int generateCustomerId() {
		return nextCustomerId++;
	}

	public Customer createPrivateCustomer(String name, String address, String postalCode, String phoneNumber,
			String email) {
		
		int id = generateCustomerId();
		Person person = new Person(name, address, postalCode, phoneNumber, email);
		Customer customer = new Customer(id, person);

		customerContainer.addCustomer(customer);

		return customer;
	}

	public Customer createBusinessCustomer(String name, String address, String postalCode, String phoneNumber,
			String email, String cvrNumber, String companyName) {

		int id = generateCustomerId();
		Person person = new Person(name, address, postalCode, phoneNumber, email);
		Customer customer = new Customer(id, person);

		Business business = new Business(cvrNumber, companyName);
		customer.setBusiness(business);

		customerContainer.addCustomer(customer);

		return customer;
	}

	public Customer findCustomerById(int customerId) {
		return customerContainer.findCustomerById(customerId);
	}

	public void addCustomer(Customer customer) {
		CustomerContainer.getInstance().addCustomer(customer);
	}

}
