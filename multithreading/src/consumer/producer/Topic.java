package consumer.producer;

import java.util.concurrent.*;

public class Topic {
    static final int QUEUE_SIZE = 3;
    static final int NUMBER_OF_HANDLER = 3;
    static final BlockingQueue<Message> BLOCKING_QUEUE = new LinkedBlockingQueue<>(QUEUE_SIZE);

    public static void main(String[] args) {
        ExecutorService consumerService = Executors.newFixedThreadPool(NUMBER_OF_HANDLER);
        ExecutorService producerService = Executors.newFixedThreadPool(NUMBER_OF_HANDLER);
        for (int i = 0; i < NUMBER_OF_HANDLER; i++) {
            producerService.submit(new Producer(BLOCKING_QUEUE, "MESSAGE_TYPE " + i));
            consumerService.submit(new Consumer(BLOCKING_QUEUE));
        }
        try {
            producerService.awaitTermination(10, TimeUnit.SECONDS);
            consumerService.awaitTermination(10, TimeUnit.SECONDS);
            producerService.shutdownNow();
            consumerService.shutdownNow();
        } catch (InterruptedException ex) {
            producerService.shutdownNow();
            consumerService.shutdownNow();
            Thread.interrupted();
        }
    }
}
