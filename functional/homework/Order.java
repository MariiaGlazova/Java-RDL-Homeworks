package homework;

import java.util.Objects;

public class Order {
    public static final float MINIMUM_ORDER_QUANTITY = 100f;
    private final OrderStatus status;
    private float price;

    public Order(OrderStatus status, float price) {
        this.status = status;
        this.price = price;
    }
    public Order(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public float getPrice() {
        return price;
    }

    public boolean isRequiredToOrder(){
        return price >= MINIMUM_ORDER_QUANTITY;
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
}
