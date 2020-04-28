package bank.correct;

class Bank {

    private int moneyAmount;

    public Bank(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void transferMoney(int amount) {
        synchronized (this) {
            if (hasEnoughMoney(amount)) {
                System.out.println(amount + " - Succeed");
                moneyAmount -= amount;
            }
        }
        System.out.println("Now in Bank: " + moneyAmount);
    }

    private boolean hasEnoughMoney(int amount) {
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


