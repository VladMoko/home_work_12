package secondTask;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        MyProducer fizzProducer = new MyProducer() {
            int n;
            boolean isUpdated = false;
            @Override
            public void setN(int n) {
                this.n = n;
                isUpdated = true;
            }

            @Override
            public boolean isUpDated() {
                return isUpdated;
            }

            @Override
            public void run() {
                while (true){
                    try {
                        if (isUpdated){
                            isUpdated = false;
                            if (n % 3 == 0){
                                queue.put("fizz");
                            }
                        }
                        Thread.sleep(100);
                    }catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        MyProducer buzzProducer = new MyProducer() {
            int n;
            boolean isUpdated = false;
            @Override
            public void setN(int n) {
                this.n = n;
                isUpdated = true;
            }

            @Override
            public boolean isUpDated() {
                return isUpdated;
            }

            @Override
            public void run() {
                while (true){
                    try {
                        if (isUpdated){
                            isUpdated = false;
                            if (n % 5 == 0){
                                queue.put("buzz");
                            }
                        }
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        MyProducer fizzBuzz = new MyProducer() {
            int n;
            boolean isUpdated = false;
            @Override
            public void setN(int n) {
                this.n = n;
                isUpdated = true;
            }

            @Override
            public boolean isUpDated() {
                return isUpdated;
            }

            @Override
            public void run() {
                while (true) {
                    try{
                        if (isUpdated){
                            isUpdated = false;
                            if (n % 3 == 0 && n % 5 == 0){
                                queue.put("fizzbuzz");
                            }
                        }
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        MyProducer number = new MyProducer() {
            int n;
            boolean isUpdated = false;
            @Override
            public void setN(int n) {
                this.n = n;
                isUpdated = true;
            }

            @Override
            public boolean isUpDated() {
                return isUpdated;
            }

            @Override
            public void run() {
                while (true){
                    try {
                        if (isUpdated){
                            isUpdated = false;
                            if (n % 3 != 0 && n % 5 != 0){
                                queue.put(String.valueOf(n));
                            }
                        }
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Runnable consumer = () -> {
            while (true){
                while (!queue.isEmpty()){
                    System.out.println(queue.poll());
                }
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(fizzProducer);
        executor.execute(buzzProducer);
        executor.execute(fizzBuzz);
        executor.execute(number);
        executor.execute(consumer);

        for (int i = 1; i <= 20; i++) {
            fizzBuzz.setN(i);
            fizzProducer.setN(i);
            buzzProducer.setN(i);
            number.setN(i);

            while (fizzBuzz.isUpDated()|| fizzProducer.isUpDated()|| buzzProducer.isUpDated()|| number.isUpDated()){
                Thread.sleep(100);
            }
        }
    }
}