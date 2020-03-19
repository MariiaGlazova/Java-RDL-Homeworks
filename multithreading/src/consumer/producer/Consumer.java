package consumer.producer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue<Message> queue;
    private static final Random random = new Random();

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        boolean isStopped = false;
        while (!isStopped) {
            try {
                Message message = queue.take();
                System.out.println(Thread.currentThread().getName() + " took message " + message);
                Thread.sleep(random.nextInt(2000) + 2000);
            } catch (InterruptedException interruptedException) {
                isStopped = true;
                Thread.interrupted();
            }
        }
    }

}
