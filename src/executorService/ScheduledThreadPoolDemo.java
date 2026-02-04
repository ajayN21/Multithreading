package executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        try (ScheduledExecutorService service = Executors.newScheduledThreadPool(1)) {

            service.scheduleAtFixedRate(new ProbeTask(),1000,2000, TimeUnit.MILLISECONDS);

            try {
                if(service.awaitTermination(10000,TimeUnit.MILLISECONDS)){
                    service.shutdownNow();
                }
            } catch (InterruptedException e) {
                service.shutdownNow();
                throw new RuntimeException(e);
            }
        }
    }
}

class ProbeTask implements Runnable{

    @Override
    public void run() {
        System.out.println("probing end points for updating ...");
    }
}
