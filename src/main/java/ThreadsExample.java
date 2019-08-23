import java.util.concurrent.atomic.AtomicInteger;

public class ThreadsExample implements Runnable{
    static AtomicInteger counter = new AtomicInteger(1); // a global counter

    public ThreadsExample() {
    }

    public static void incrementCounter(){
        System.out.println("ThreadID " + Thread.currentThread().getId() + " : " + counter.getAndIncrement());
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (counter.get() < 1000) {
            incrementCounter();
        }
    }
}