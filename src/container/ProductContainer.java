package container;

import java.util.ArrayList;
import model.Product;

public class ProductContainer {
	private ArrayList<Product> product;
	private static ProductContainer instance;

	private ProductContainer() {
		product = new ArrayList<>();

	}

	public static ProductContainer getInstance() {
		if (instance == null) {
			instance = new ProductContainer();
		}
		return instance;
	}

	public ArrayList<Product> getProduct() {
		return product;
	}
}
