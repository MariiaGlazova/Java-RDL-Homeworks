package io.humb1t.homework;

import java.util.*;
import java.util.stream.Collectors;

import static io.humb1t.Order.OrderStatus.*;

public class IterationTest {
    private static final List<Order> orders = Arrays.asList(new Order(NOT_STARTED, 200.99f), new Order(NOT_STARTED, 200.99f),
            new Order(COMPLETED, 69.99f), new Order(NOT_STARTED, 200.99f), new Order(COMPLETED, 150.99f), new Order(COMPLETED, 150.99f),
            new Order(COMPLETED, 100.99f));

    public static void main(String[] args) {
        printFilteredCollection();
        printCollectionWithoutDuplicates();
    }

    private static void printCollectionWithoutDuplicates() {
        Set<Order> uniqueOrders = new HashSet<>(orders);
        System.out.println("Not ordered: " + uniqueOrders);

        Set<Order> uniqueLinkedOrders = new LinkedHashSet<>(orders);
        System.out.println("Ordered: " + uniqueLinkedOrders);
    }

    private static void printFilteredCollection() {

        System.out.println("Stream API output");
        orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.COMPLETED)
                .filter(order -> order.getPrice() > 100f)
                .forEach(System.out::println);

        System.out.println("\nFor each output");
        for (Order order : orders) {
            if (order.getPrice() > 100f) {
                System.out.println(order.toString());
            }
        }

        System.out.println("\nIterator output");
        for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext(); ) {
            Order next = iterator.next();
            if (next.getPrice() > 100f) {
                System.out.println(next.toString());
            }
        }

        Map<Order.OrderStatus, List<Order>> ordersByStatus = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
        System.out.println(ordersByStatus);
    }
}
