package concurrentCollection;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private static final int NUM_OF_TOURISTS = 5;
    private static final int NUM_OF_STAGES = 3;
    private static final CyclicBarrier barrier = new CyclicBarrier(NUM_OF_TOURISTS, () -> System.out.println("Tour Guide is speaking"));

    public static void main(String[] args) {
        for(int i=0;i<NUM_OF_TOURISTS;i++){
            Thread thread = new Thread(new Tourist(i));
            thread.start();
        }
    }


    static class Tourist implements Runnable {

        private final int id;

        Tourist(int id) {
            this.id = id;
        }

        @Override
        public void run() {

            for (int i = 0; i < NUM_OF_STAGES; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Tourist " + id + " arrived at " + (i + 1));

                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}


