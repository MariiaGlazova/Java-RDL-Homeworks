package homework;

import static homework.Order.OrderStatus.*;

public interface OrderFactory {

    default Order createOrderNotStarted() {
        return new Order(NOT_STARTED);
    }

    default Order createOrderProcessing() {
        return new Order(PROCESSING);
    }

    default Order createOrderCompleted() {
        return new Order(COMPLETED);
    }
}
