package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
    public static void main(String[] args) {

        try (ExecutorService service = Executors.newSingleThreadExecutor()) {

            for (int i = 0; i < 5; i++) {
                service.execute(new Task(i));
            }
        }

    }
}

class Task implements Runnable {

    private final int id;

    Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id " + id + " being executed by " + Thread.currentThread().getName());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
