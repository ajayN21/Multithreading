package concurrentCollection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

    private static final int QUEUE_CAPACITY = 10;
    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    queue.put(i);
                    System.out.println("Task produced " + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerOne = new Thread(() -> {
            while (true) {
                try {
                    int task = queue.take();
                    processTask(task, "consumerOne");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerTwo = new Thread(() -> {
            while (true) {
                try {
                    int task = queue.take();
                    processTask(task, "consumerTwo");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumerOne.start();
        consumerTwo.start();
    }

    private static void processTask(int task, String consumerOne) throws InterruptedException {
        System.out.println(task + " is getting processed by " + consumerOne);
        Thread.sleep(1000);
        System.out.println(task + " consumed by " + consumerOne);
    }
}
