public class Factory {

    private long createdPaperclips;
    private long wire;
    private long clipsPersSecond;
    private long unsoldInventory;

    public Factory() {
        this.wire = 1000;
    }

    public long getCreatedPaperclips() {
        return createdPaperclips;
    }

    public void setCreatedPaperclips(long createdPaperclips) {
        this.createdPaperclips = createdPaperclips;
    }

    public long getWire() {
        return wire;
    }

    public void setWire(long wire) {
        this.wire = wire;
    }

    public long getClipsPersSecond() {
        return clipsPersSecond;
    }

    public void setClipsPersSecond(long clipsPersSecond) {
        this.clipsPersSecond = clipsPersSecond;
    }

    public long getUnusedInventory() {
        return unsoldInventory;
    }

    public void setUnusedInventory(long unusedInventory) {
        this.unsoldInventory = unusedInventory;
    }

    public void makePaperclip(){
        if (wire > 0) {
            this.wire -= 1;
            this.createdPaperclips += 1;
            this.unsoldInventory += 1;
        }
    }
}
