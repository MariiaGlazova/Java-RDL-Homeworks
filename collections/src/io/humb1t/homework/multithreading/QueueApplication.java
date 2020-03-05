package io.humb1t.homework.multithreading;

import java.util.concurrent.ConcurrentLinkedQueue;


public class QueueApplication {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<PaymentRequest> incomingRequests = new ConcurrentLinkedQueue<>();
        for (int i = 0; i <= 100; ++i) {
            incomingRequests.add(new PaymentRequest(i, (int) (Math.random() * 100)));
        }

        new Thread(() -> {
            while (!incomingRequests.isEmpty()) {
                System.out.println("Consumer №1 process:" + incomingRequests.poll());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (!incomingRequests.isEmpty()) {
                System.out.println("Consumer №2 process:" + incomingRequests.poll());
                try {
                    Thread.sleep(999);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (!incomingRequests.isEmpty()) {
                System.out.println("Consumer №3 process:" + incomingRequests.poll());
                try {
                    Thread.sleep(998);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
