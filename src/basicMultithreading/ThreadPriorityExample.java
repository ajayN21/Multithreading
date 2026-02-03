package basicMultithreading;

public class ThreadPriorityExample {
    /*default priority of a thread is 5*/
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+ " says Hi");
        System.out.println(Thread.currentThread().getPriority());

        Thread one = new Thread(()->{
            System.out.println("Thread one says Hi as well");
        });

        one.setPriority(Thread.MAX_PRIORITY);
        one.start();
        System.out.println(one.getPriority());
    }
}
