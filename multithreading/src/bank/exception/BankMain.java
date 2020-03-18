package bank.exception;

import bank.InsufficientFundsException;

class BankMain {
    public static void main(String[] args) {
        try {
            new Thread(new BankUser(), "1").start();
            new Thread(new BankUser(), "2").start();
            new Thread(new BankUser(), "3").start();
            new Thread(new BankUser(), "4").start();
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }

    }
}
