package executorService;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        try (ExecutorService service = Executors.newFixedThreadPool(2)) {
            Future<Integer> future = service.submit(new ReturnValueTask());

            /*System.out.println(future.cancel(true));
            System.out.println(future.isCancelled());
            System.out.println(future.isDone());*/

            System.out.println(future.get());
            //System.out.println(future.get(4,TimeUnit.SECONDS));
            System.out.println("main thread execution completed!");
        }
    }
}


class ReturnValueTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return 21;
    }
}
