package consumer.producer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    public static final int NUMBER_OF_MESSAGES = 5;
    public final BlockingQueue<Message> queue;
    private static final Random random = new Random();
    private static int pointer = 0;
    private final String text;

    public Producer(BlockingQueue<Message> queue, String message) {
        this.text = message;
        this.queue = queue;

    }

    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_MESSAGES; i++) {
            try {
                Message message = new Message(text, i);
                queue.put(message);
                System.out.println(Thread.currentThread().getName() + " put message " + message);
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException interruptedException) {
                Thread.interrupted();
                break;
            }
        }
    }
}

    /*
        while (pointer < NUMBER_OF_MESSAGES){
        Message message = new Message(text, pointer);
        try {
        queue.put(message);
        System.out.println(Thread.currentThread().getName() + " put message " + message);
        Thread.sleep(random.nextInt(2000) + 2000);
        } catch (InterruptedException interruptedException) {

        Thread.interrupted();
        }
        pointer++;
        }

     */