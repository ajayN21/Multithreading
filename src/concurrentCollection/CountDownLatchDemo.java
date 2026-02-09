package concurrentCollection;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int noOfChefs = 3;
        CountDownLatch latch = new CountDownLatch(noOfChefs);

        new Thread(new Chef("chef A","pizza",latch)).start();
        new Thread(new Chef("chef B","pasta",latch)).start();
        new Thread(new Chef("chef C","soup",latch)).start();

        latch.await();

        System.out.println("All the dishes are ready to serve.");
    }
}

class Chef implements Runnable{

    private final String name;
    private final String dish;
    private final CountDownLatch latch;

    Chef(String name, String dish, CountDownLatch latch) {
        this.name = name;
        this.dish = dish;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(name+" is preparing "+dish);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name+" prepared the "+dish);
        latch.countDown();
    }
}
