import java.util.concurrent.atomic.AtomicInteger;

public class Factory implements Runnable{

    AtomicInteger createdPaperclips = new AtomicInteger(0); // a global counter

    //private long createdPaperclips;
     AtomicInteger  wire = new AtomicInteger(1000);
    private long clipsPersSecond;
     AtomicInteger unsoldInventory = new AtomicInteger(0);


    public Factory() {

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

    public void setWire(AtomicInteger wire) {
        this.wire = wire;
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
        }
    }
}
