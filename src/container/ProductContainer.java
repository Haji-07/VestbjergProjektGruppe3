package container;

import java.util.ArrayList;
import model.Product;
import model.ProductCopy;
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
	public void addProductCopy(int productId, int copyId, int quantity) {
	Product foundProduct = null;
		for (Product p : products) {
			if (p.getProductId() == productId) {
				foundProduct = p;
				break;
			}
		}
		if(foundProduct != null) {
			ProductCopy copy = new ProductCopy(copyId, quantity);
			foundProduct.addProductCopy(copy);
		}
	}
	public ProductCopy findCopyById(int copyId) {
		for (Product p : products) {
			ProductCopy copy = p.findCopy(copyId);
			if(copy != null) {
				return copy;
			}
		}
		return null;
	}
}
