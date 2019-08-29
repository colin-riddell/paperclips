package views;

public class ViewModel {

    private int createdPaperclips;
    private int wire;
    private long clipsPersSecond;
    private int unsoldInventory;

    public ViewModel(int createdPaperclips, int wire, long clipsPersSecond, int unsoldInventory) {
        this.createdPaperclips = createdPaperclips;
        this.wire = wire;
        this.clipsPersSecond = clipsPersSecond;
        this.unsoldInventory = unsoldInventory;
    }

    public ViewModel() {
    }

    public int getCreatedPaperclips() {
        return createdPaperclips;
    }

    public void setCreatedPaperclips(int createdPaperclips) {
        this.createdPaperclips = createdPaperclips;
    }

    public int getWire() {
        return wire;
    }

    public void setWire(int wire) {
        this.wire = wire;
    }

    public long getClipsPersSecond() {
        return clipsPersSecond;
    }

    public void setClipsPersSecond(long clipsPersSecond) {
        this.clipsPersSecond = clipsPersSecond;
    }

    public int getUnsoldInventory() {
        return unsoldInventory;
    }

    public void setUnsoldInventory(int unsoldInventory) {
        this.unsoldInventory = unsoldInventory;
    }
}
