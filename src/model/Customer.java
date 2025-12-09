package model;

public class Customer {

	private int CustomerId;
	private Person person;
	private Business business;
	
	public Person getPerson(){
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Business getBusiness() {
		return business;
	}
	
	public void setBusiness(Business business) {
		this.business = business;
	}
}
