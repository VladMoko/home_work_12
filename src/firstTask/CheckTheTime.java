package firstTask;

import java.util.concurrent.atomic.AtomicInteger;

public class CheckTheTime {

    public static void main(String[] args) {
        AtomicInteger oneSecond = new AtomicInteger();
        AtomicInteger fiveSecond = new AtomicInteger();
        new Thread(() -> {
            while (true){
                System.out.println("Минуло " + oneSecond);
                oneSecond.addAndGet(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })
                .start();
        new Thread(() -> {
            while (true){
                System.out.println("Минуло " + fiveSecond);
                fiveSecond.addAndGet(5);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        })
                .start();
    }
}
