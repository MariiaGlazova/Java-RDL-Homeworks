package bank.correct.concurrent;

import bank.InsufficientFundsException;

import java.util.concurrent.locks.ReentrantLock;

class BankMain {
    public static void main(String[] args) {
        try{
            new Thread(new UserBank(),"1" ).start();
            new Thread(new UserBank(),"2" ).start();
            new Thread(new UserBank(),"3" ).start();
            new Thread(new UserBank(),"4" ).start();
            new Thread(new UserBank(),"5" ).start();
        }catch (InsufficientFundsException e){
            e.printStackTrace();
        }
    }
}
