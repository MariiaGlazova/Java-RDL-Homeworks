package philosophers;

import java.util.Random;

class Philosopher extends Thread {
    private final Fork leftFork;
    private final Fork rightFork;
    private final String name;
    private final Random random = new Random();

    public Philosopher(String name, Fork left, Fork right) {
        this.name = name;
        leftFork = left;
        rightFork = right;
    }

    public void eat() {
        System.out.println(name + " trying to take left fork " + leftFork.getName());
        if (leftFork.take()) {
            System.out.println(name + " trying to take right fork " + rightFork.getName());
            if (rightFork.take()) {
                System.out.println(name + " start eating spaghetti...");
                try {
                    Thread.sleep(random.nextInt(5000) + 5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            leftFork.release();
            System.out.println(name + " Oh right fork " + rightFork.getName() + " is already taken. Need to left fork " + leftFork.getName());
        } else {
            System.out.println(name + "No available forks. Start Thinking instead ");
        }
        think();
    }

    public void think() {
        System.out.println(name + " : Thinking...");
        try {
            Thread.sleep(random.nextInt(5000) + 5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    public void run() {
        while (true) {
            eat();
        }
    }
}