package io.humb1t.homework.multithreading;

import java.util.Objects;

public class PaymentRequest {

    private int userId;
    private double discount;

    public PaymentRequest(int userId, double discount) {
        this.userId = userId;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentRequest that = (PaymentRequest) o;
        return userId == that.userId &&
                Double.compare(that.discount, discount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, discount);
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "userId=" + userId +
                ", discount=" + discount +
                '}';
    }
}