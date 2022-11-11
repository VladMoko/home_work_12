package firstTask;

public class CheckTheTime {

    public static void main(String[] args) {
        Thread thread = new UpDateTimeEverySecond();
        Thread thread1 = new UpDateTimeEveryFiveSecond();
        thread.start();
        thread1.start();
    }

}
