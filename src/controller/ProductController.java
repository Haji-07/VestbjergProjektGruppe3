package controller;

import model.Product;
import container.ProductContainer;
import model.ProductCopy;
import java.util.ArrayList;

public class ProductController {
	private ArrayList<Product> products;

	public ProductController() {
		this.products = new ArrayList<>();

		generateTestData();

	}

	private void generateTestData() {
		createProduct("P-100", "Power Drill", "18V Cordless Drill", "Tools", "Bosch EasyImpact", "BARD1",
				"DIY Section 1", 599, 50);
		createProduct("P-101", "Hammer", "Heavy Duty Hammer", "Tools", "Stanley Hammer", "BARD2", "DIY Section 1", 200,
				100);
		createProduct("P-102", "Wrench", "Adjustable Wrench", "Tools", "DeWalt Wrench", "BARD3", "DIY Section  1", 250,
				70);
		createProduct("P-103", "Nails", "Pack of 100  Nails", "Hardware", "Common nails", "BARDT4",
				"DIY Section 2 and Timber Section 2", 100, 10000);
		createProduct("P-104", "Planks", "Pack of 50x70 Hardwood Planks", "Hardwoods", "Silvan Hardwood Planks",
				"BART1", "Timber Section 1", 200, 500);
	}

	public void createProduct(String productId, String name, String description, String category, String model,
			String barcode, String location, double price, int quantity) {
		Product newProduct = new Product(productId, name, description, category, model, barcode, location, price,
				quantity);
		ProductContainer container = ProductContainer.getInstance();
		container.addProduct(newProduct);
	}

	public Product findProductByBarcode(String barcode) {
		return ProductContainer.getInstance().findProductByBarcode(barcode);
	}

	public Product findProductByProductId(String productId) {
		return ProductContainer.getInstance().findProductByProductId(productId);
	}

	public Product findProductDetails(String productId, String name) {
		return ProductContainer.getInstance().findProductDetails(productId, name);
	}

	public void createProductCopy(String productId, int copyId, int quantity) {
		ProductContainer.getInstance().addProductCopy(productId, copyId, quantity);
	}

	public ProductCopy findCopyById(int id) {
		return ProductContainer.getInstance().findCopyById(id);
	}

	public void addProduct(Product p) {
		ProductContainer.getInstance().addProduct(p);
	}

}
