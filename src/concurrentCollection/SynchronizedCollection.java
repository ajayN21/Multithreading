package concurrentCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollection {
    public static void main(String[] args) throws InterruptedException {

        //List<Integer> data = new ArrayList<>();
        List<Integer> data = Collections.synchronizedList(new ArrayList<>());

        Thread one = new Thread(()-> {
            for (int i=0;i<1000;i++){

                data.add(i);
            }
        });

        Thread two = new Thread(()-> {
            for (int i=0;i<1000;i++){

                data.add(i);
            }
        });

        one.start();
        two.start();
        one.join();
        two.join();

        System.out.println(data.size());
    }
}
