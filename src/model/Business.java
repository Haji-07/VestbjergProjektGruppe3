package model;

public class Business {

	private String cvrNumber;
	private String companyName;

	public Business(String cvrNumber, String companyName) {
		super();
		this.cvrNumber = cvrNumber;
		this.companyName = companyName;
	}

	public String getCvrNumber() {
		return cvrNumber;
	}

	public void setCvrNumber(String cvrNumber) {
		this.cvrNumber = cvrNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return companyName + " (CVR: " + cvrNumber + ")";
	}

}
