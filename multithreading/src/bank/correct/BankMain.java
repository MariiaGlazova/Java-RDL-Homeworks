package bank.correct;

import bank.InsufficientFundsException;

class BankMain {
    public static final int NUMBER_OF_BANK_USERS = 5;

    public static void main(String[] args) {
        try {
            for (int i = 0; i < NUMBER_OF_BANK_USERS; i++) {
                new Thread(new BankUser(), String.valueOf(i)).start();
            }
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }

    }
}

