package basicMultithreading;

public class JoinThreadExample {
    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread1 : " + i);
            }
        }
        );

        Thread two = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                System.out.println("Thread2 : " + i);
            }
        }
        );

        one.start();
        two.start();
        one.join();
        System.out.println("Thread execution task completed!");
    }
}
