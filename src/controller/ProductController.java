package controller;
import model.Product;
import container.ProductContainer;

public class ProductController {

	public ProductController() {	
		
	}
	public void createProduct(int productId, String name, String description, String category, String model, String barcode, String location, double price) {
		Product newProduct = new Product(productId, name, description, category, model, barcode, location, price);
		ProductContainer container = ProductContainer.getInstance();
		container.addProduct(newProduct);
	}
	public Product findProductByBarcode(String barcode) {
		return ProductContainer.getInstance().findProductByBarcade(barcode);
	}
}
