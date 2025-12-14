package model;

public class Discount {
	
	private DiscountType type;
	private double percentage;

	public Discount(DiscountType type, double percentage) {
		this.type = type;
		this.percentage = percentage;
	}

	public double getPercentage() {
		return percentage;
	}

	public DiscountType getType() {
		return type;
	}

}
