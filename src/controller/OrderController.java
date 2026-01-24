package controller;

import container.OrderContainer;
import model.Order;
import model.Product;
import model.Customer;

public class OrderController {

    private OrderContainer orderContainer;
    private ProductController productController;
    private CustomerController customerController;
    private Order o;

    public OrderController() {
        orderContainer = OrderContainer.getInstance();
        productController = new ProductController();
        customerController = new CustomerController();
    }

    public void createOrder() {
        o = new Order();
    }

    public void addProductToOrder(String barcode, int quantity) {
        Product p = productController.findProductByBarcode(barcode);
        if (o != null && p != null) {
            o.addOrderLine(p, quantity);
        }
    }

    public void addCustomerToOrder(int customerId) {
        Customer c = customerController.findCustomerById(customerId);
        if (o != null && c != null) {
            o.addCustomer(c);
        }
    }

    public double calculateOrderTotal() {
        if (o != null) {
            return o.calculateTotal();
        }
        return 0.0;
    }

    public void saveOrder() {
        if (o != null) {
            orderContainer.addOrder(o);
        }
    }

    public Order finishOrder() {
        saveOrder();
        return o;
    }
    
    public Order getOrder() {
        return o;
    }

    public boolean hasActiveOrder() {
        return o != null;
    }

}
