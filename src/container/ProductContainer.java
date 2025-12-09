package container;

import java.util.ArrayList;
import model.Product;

public class ProductContainer {
	private ArrayList<Product> products;
	private static ProductContainer instance;

	private ProductContainer() {
		products = new ArrayList<>();

	}

	public static ProductContainer getInstance() {
		if (instance == null) {
			instance = new ProductContainer();
		}
		return instance;
	}

	public void addProduct(Product product) {
		products.add(product);

	}

	public Product findProductByBarcade(String barcode) {
		for (Product p : products) {
			if (p.getBarcode().equals(barcode)) {
				return p;
			}
		}
		return null;
	}
}
