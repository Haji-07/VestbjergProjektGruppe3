package model;

public class Customer {

	private int customerId;
	private Person person;
	private Business business;
	
	public Customer(int customerId, Person person) {
		this.customerId = customerId;
		this.person = person;
	}
	
	public Person getPerson(){
		return person;
	}
	
	public Business getBusiness() {
		return business;
	}
	
	public void setBusiness(Business business) {
		this.business = business;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public boolean isBusinessCustomer() {
	    return business != null;
	}

}
