package bank.correct;

class BankUser implements Runnable {

    public static final Bank bank = new Bank(3000);

    @Override
    public void run() {
        int amount;
        while (true) {
            amount = (int) (Math.random() * 100);
            bank.transferMoney(amount);
            try {
                Thread.sleep((int) (Math.random() * 200) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
