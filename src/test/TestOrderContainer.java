package test;

import container.OrderContainer;
import model.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOrderContainer{
	
	@Test
	 void testSingletonInstance() {
	        OrderContainer oc1 = OrderContainer.getInstance();
	        OrderContainer oc2 = OrderContainer.getInstance();

	        assertSame(oc1, oc2);
	    }
	
	@Test
    void testAddOrder() {
        OrderContainer oc = OrderContainer.getInstance();
        Order o = new Order();

        assertDoesNotThrow(() -> oc.addOrder(o));
    }
}