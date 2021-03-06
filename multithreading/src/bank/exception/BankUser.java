
package bank.exception;

class BankUser implements Runnable {
    public static final Bank bank = new Bank(3000);

    @Override
    public void run() {
        int amount = (int) (Math.random() * 300) + 500;
        while (true) {
            if (!bank.hasEnoughMoney(amount)) {
                break;
            }
            //it will be better to sleep here a little bit for correct behavior
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            bank.transferMoney(amount);
            amount = (int) (Math.random() * 300) + 200;
        }
        System.out.println("Thread:" + Thread.currentThread() + " stop working.");
    }
}
