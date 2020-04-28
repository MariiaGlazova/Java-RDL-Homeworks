package bank.correct.concurrent;

import java.util.concurrent.locks.ReentrantLock;

class Bank {

    private int moneyAmount;
    private final ReentrantLock lock = new ReentrantLock();

    public Bank(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void transferMoney(int amount) {
        lock.lock();
        if (hasEnoughMoney(amount)) {
            System.out.println(amount + " - Succeed");
            moneyAmount -= amount;
        }
        lock.unlock();
        System.out.println("Now in Bank: " + moneyAmount);
    }

    private boolean hasEnoughMoney(int amount) {
        System.out.println("Trying to take " + amount + " from the bank: " + moneyAmount + " Thread:" + Thread.currentThread());
        return moneyAmount > amount;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "moneyAmount=" + moneyAmount +
                '}';
    }
}


