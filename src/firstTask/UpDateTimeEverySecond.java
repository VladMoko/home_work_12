package firstTask;



public class UpDateTimeEverySecond extends Thread{

    private int second = 0;
    @Override
    public void run() {
        while (!(second < 0)){
            second++;
            System.out.println("second = " + second);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
