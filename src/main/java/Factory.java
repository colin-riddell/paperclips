import java.util.concurrent.atomic.AtomicInteger;

public class Factory implements Runnable {

    private AtomicInteger createdPaperclips = new AtomicInteger(0);
    private static AtomicInteger  wire = new AtomicInteger(1000);
    private long clipsPersSecond;
    private AtomicInteger unsoldInventory = new AtomicInteger(0);

    private static int clipperDelay = 1000; // the clip rate shared across all clippers


    public Factory() {

    }

    public static int getClipperDelay() {
        return clipperDelay;
    }

    public static void setClipperDelay(int clipperDelay) {
        Factory.clipperDelay = clipperDelay;
    }

    public AtomicInteger getCreatedPaperclips() {
        return createdPaperclips;
    }

    public void setCreatedPaperclips(AtomicInteger createdPaperclips) {
        this.createdPaperclips = createdPaperclips;
    }

    public AtomicInteger getWire() {
        return wire;
    }


    public static void setWire(int wireToAdd){
        wire.compareAndSet(wire.get(), wire.get()+ wireToAdd);
    }
    public long getClipsPersSecond() {
        return clipsPersSecond;
    }

    public void setClipsPersSecond(long clipsPersSecond) {
        this.clipsPersSecond = clipsPersSecond;
    }

    public AtomicInteger getUnsoldInventory() {
        return unsoldInventory;
    }

    public void setUnsoldInventory(AtomicInteger unusedInventory) {
        this.unsoldInventory = unusedInventory;
    }

    public void makePaperclip(){
        wire.decrementAndGet();
        createdPaperclips.incrementAndGet();
        unsoldInventory.incrementAndGet();
    }

    public void runAutoClipper(){

        System.out.println(Thread.currentThread().getName() + ": " + createdPaperclips.get());
            makePaperclip();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void run() {
        while(wire.get() > 0 ){
            this.runAutoClipper();
            try {
                Thread.sleep(clipperDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
