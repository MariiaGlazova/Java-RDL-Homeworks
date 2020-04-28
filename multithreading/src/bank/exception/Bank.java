package bank.exception;

import bank.InsufficientFundsException;

class Bank {
    private int moneyAmount;

    public Bank(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void transferMoney(int amount) {
        if (moneyAmount < amount) {
            throw new InsufficientFundsException("User's money amount(" + amount + ") is more than the Bank provides(" + moneyAmount + ")" +
                    " in Thread:" + Thread.currentThread());
        }
        moneyAmount -= amount;
    }

    public boolean hasEnoughMoney(int amount) {
        System.out.println("Trying to take " + amount + " from the bank: " + moneyAmount + ". Thread:" + Thread.currentThread());
        return moneyAmount > amount;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "moneyAmount=" + moneyAmount +
                '}';
    }
}
