import org.junit.Before;
import org.junit.Test;
import views.StatusView;

import static org.junit.Assert.assertEquals;

public class FactorTests {

    @Before
    public void before(){
        Factory.setClipperDelay(3);
    }


    @Test
    public void canMakeOnePaperclip(){
        Factory  factory = new Factory(new StatusView());

        //given we have a factory

        //and factory has 1000 wire
        assertEquals(1000, factory.getWire().get());

        //when we make a paperclip
        factory.makePaperclip();

        //then we should have one createdPaperclip
        assertEquals(1, factory.getCreatedPaperclips().get());
        // and one unsoldInventory
        assertEquals(1, factory.getUnsoldInventory().get());
        // and 999 wire
        assertEquals(999, factory.getWire().get());

    }

    @Test
    public void canRunAutoClipper(){
        Factory  factory = new Factory(new StatusView());

        Thread thread = new Thread(factory);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(1000, factory.getUnsoldInventory().get());
    }

    @Test
    public void canRunAutoClipperAndAddWire(){
        Factory  factory = new Factory(new StatusView());
        // start the autoclipper
        Thread thread = new Thread(factory);
        thread.start();

        // wait a second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // add more wire
        Factory.setWire(500);

        // wait on thread
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(1500, factory.getUnsoldInventory().get());
    }


}
