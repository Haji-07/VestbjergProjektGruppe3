package model;

import java.util.ArrayList;

public class Product {
	private int productId;
	private String name;
	private String description;
	private String category;
	private String model;
	private String barcode;
	private String location;
	private double price;
	
	private ArrayList<ProductCopy> copies;
	
	public Product(int productId, String name, String description, String category, String model, String barcode,
			String location, double price) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.category = category;
		this.model = model;
		this.barcode = barcode;
		this.location = location;
		this.price = price;
		this.copies = new ArrayList<>();
		
	}

	public ProductCopy findCopy(int copyId) {
		for (ProductCopy copy : copies) {
			if (copy.getCopyId() == copyId) {
				return copy;
			}
		}
		return null;
	}
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public void addProductCopy(ProductCopy copy) {
		copies.add(copy);
		
	}
}
