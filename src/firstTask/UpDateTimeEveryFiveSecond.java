package firstTask;

public class UpDateTimeEveryFiveSecond extends Thread{
    private int everyFiveSecond = 0;
    @Override
    public void run() {
        while (!(everyFiveSecond < 0)){
            System.out.println("everyFiveSecond = " + everyFiveSecond);
            everyFiveSecond += 5;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
