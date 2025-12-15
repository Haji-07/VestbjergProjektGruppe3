package test;

import container.OrderContainer;
import model.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class TestOrderContainer {

    @Test
    void TestSingletonInstance() {
        assertSame(
            OrderContainer.getInstance(),
            OrderContainer.getInstance()
        );
    }

    @Test
    void TestAddOrder() {
        OrderContainer.getInstance().addOrder(new Order());
    }
}

