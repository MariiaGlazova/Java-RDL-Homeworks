package io.humb1t.task2;

public class SomeResource implements AutoCloseable {
    int numberOfResource;

    public SomeResource(int numberOfResource) {
        this.numberOfResource = numberOfResource;
    }

    public void doIt() {
        System.out.println("someResource " + numberOfResource + " doing something");
    }

    @Override
    public void close() {
        System.out.println("someResource " + numberOfResource + " closed");
    }
}
