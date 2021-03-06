import views.StatusView;

import java.util.ArrayList;
import java.util.List;

public class Paperclips {

    private List<Thread> threads;
    private Factory factory;
    private StatusView view;

    public Paperclips(Factory factory) {
        this.factory = factory;
        threads = new ArrayList<>();
        this.view = new StatusView();

    }

    public List<Thread> getThreads() {
        return threads;
    }

    public static void addWire(int wire){
        Factory.setWire(wire);
    }

    public void setThreads(ArrayList<Thread> threads) {
        this.threads = threads;
    }

    public void addAutoClipper(){
        Thread thread = new Thread(factory);
        threads.add(thread);

    }

    public void startAutoClippers(){
        for(Thread thread: this.threads){
            if (!thread.isAlive()){
                thread.start();
            }
        }
    }

    public void joinAutoClippers(){
        for(Thread thread: this.threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
