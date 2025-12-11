package container;

import java.util.ArrayList;
import model.Product;
import model.ProductCopy;

public class ProductContainer {
	private ArrayList<Product> products;
	private ArrayList<ProductCopy> copies;
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

	public void addProductCopy(String productId, int copyId, int quantity) {
		ProductCopy newCopy = new ProductCopy(copyId, quantity);
		Product p = ProductContainer.getInstance().findProductByProductId(productId);
		if (p != null) {
			p.addProductCopy(newCopy);
		}

	}

	public Product findProductByBarcode(String barcode) {
		Product res = null;
		for (Product p : products) {
			if (p.getBarcode() == (barcode)) {
				res = p;
			}

		}
		return res;
	}

	public Product findProductByProductId(String productId) {
		Product res = null;
		for (Product p : products) {
			if (p.getProductId() == productId) {
				res = p;
			}
		}
		return res;
	}

	public ProductCopy findCopyById(int copyId) {
	    ProductCopy res = null;
	    for (ProductCopy pc : copies) {
	        if (pc.getCopyId() == copyId) {
	            res = pc;
	        }
	    }
	    return res;
	}
	
	public Product findProductDetails(String name, String productId) {
		Product res = null;
		for(Product p : products) {
			if (productId != null && !productId.isEmpty() && p.getProductId().equals(productId)) {
				return p;
			}
			if(name != null && !name.isEmpty() && p.getName().equals(name)) {
				return p;
			}
			
		}
		return null;
	}
	public void addProduct(Product p) {
	    products.add(p);
	}

}
