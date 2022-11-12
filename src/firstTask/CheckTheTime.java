package firstTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckTheTime {

    public static void main(String[] args) {
        AtomicInteger oneSecondPassed = new AtomicInteger();
        AtomicInteger fiveSecondPassed = new AtomicInteger();

        Runnable oneSecond = new Runnable() {
            @Override
            public void run() {
                System.out.println("Passed " + oneSecondPassed);
                oneSecondPassed.addAndGet(1);
            }
        };

        Runnable fiveSecond = new Runnable() {
            @Override
            public void run() {
                System.out.println("Passed " + fiveSecondPassed);
                fiveSecondPassed.addAndGet(5);
            }
        };


        ScheduledExecutorService executors = Executors.newScheduledThreadPool(2);
        executors.scheduleAtFixedRate(oneSecond, 0, 1, TimeUnit.SECONDS);
        executors.scheduleAtFixedRate(fiveSecond, 0, 5, TimeUnit.SECONDS);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executors.shutdown();
    }
}
