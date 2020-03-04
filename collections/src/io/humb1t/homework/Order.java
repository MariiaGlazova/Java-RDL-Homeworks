package io.humb1t.homework;

import java.util.Objects;

public class Order {
    private final OrderStatus status;
    private final float price;

    public Order(OrderStatus status, float price) {
        this.status = status;
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", price=" + price +
                '}';
    }

    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Float.compare(order.price, price) == 0 &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, price);
    }
}
