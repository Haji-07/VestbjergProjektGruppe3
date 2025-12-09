package container;

import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerContainer {
	
	private static CustomerContainer instance;
	

	private List<Customer> customers;
	
	private CustomerContainer() {
		customers = new ArrayList<>();
	}
	
	public static CustomerContainer getInstance() {
		if (instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public Customer findCustomerById(int customerId) {
		for (Customer c : customers) {
			if (c.getCustomerId() == customerId) {
				return c;
			}
		}
		return null;
	}
}
