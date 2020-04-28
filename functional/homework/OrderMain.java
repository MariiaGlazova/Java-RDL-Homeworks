package homework;

import java.util.Arrays;
import java.util.List;

import static homework.Order.OrderStatus.*;

public class OrderMain {
    private static final List<Order> orders = Arrays.asList(new Order(NOT_STARTED, 200.99f), new Order(NOT_STARTED, 200.99f),
            new Order(COMPLETED, 69.99f), new Order(PROCESSING, 200.99f), new Order(COMPLETED, 150.99f), new Order(COMPLETED, 150.99f),
            new Order(COMPLETED, 100.99f));

    public static void main(String[] args) {
        orders.stream().filter(Order::isRequiredToOrder).forEach(System.out::println);
    }
}
