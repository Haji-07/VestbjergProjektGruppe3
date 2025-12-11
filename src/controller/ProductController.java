package controller;

import model.Product;
import container.ProductContainer;
import model.ProductCopy;

public class ProductController {

	public ProductController() {

	}

	public void createProduct(String productId, String name, String description, String category, String model,
			String barcode, String location, double price) {
		Product newProduct = new Product(productId, name, description, category, model, barcode, location, price);
		ProductContainer container = ProductContainer.getInstance();
		container.addProduct(newProduct);
	}

	public Product findProductByBarcode(String barcode) {
		return ProductContainer.getInstance().findProductByBarcode(barcode);
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
}
