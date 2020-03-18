package bank.correct.concurrent;

import java.util.concurrent.locks.ReentrantLock;

class UserBank implements Runnable{

    public static final Bank bank = new Bank(3000);

    @Override
    public void run() {
        int amount;
        while (true){
            amount = (int) (Math.random() * 100);
            bank.transferMoney(amount);
            try {
                Thread.sleep((int) (Math.random() * 200) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
