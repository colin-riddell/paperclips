import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import views.StatusView;

import static org.junit.Assert.assertEquals;

public class PaperclipsTest {

    @Before
    public void before(){
        Factory.setClipperDelay(4);
    }


    @After
    public void after(){


    }


    @Test
    public void canAddAndRunOneAutoClipper(){
        Factory  factory = new Factory(new StatusView());

        Paperclips paperclips   = new Paperclips(factory);
        paperclips.addAutoClipper();
        paperclips.startAutoClippers();
        paperclips.joinAutoClippers();

    }

    @Test
    public void canAddAndRunTwoAutoClipper(){
        Factory  factory = new Factory(new StatusView());

        Paperclips paperclips   = new Paperclips(factory);
        paperclips.addAutoClipper();
        paperclips.startAutoClippers();

        // wait a couple of seconds to simulate adding thread while thread running
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        paperclips.addAutoClipper();
        paperclips.startAutoClippers();

        paperclips.joinAutoClippers();
    }


    @Test
    public void cannRunTwoAutoClippersAndAddWire(){
        Factory  factory = new Factory(new StatusView());

        Paperclips paperclips   = new Paperclips(factory);
        paperclips.addAutoClipper();
        paperclips.startAutoClippers();

        // wait a couple of seconds to simulate adding thread while thread running
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        paperclips.addAutoClipper();
        paperclips.startAutoClippers();
        Factory.setWire(200);
        paperclips.joinAutoClippers();
    }

    @Test
    public void cannRunOneAutoClipperAndAddWire(){

        Factory  factory = new Factory(new StatusView());

        Paperclips paperclips   = new Paperclips(factory);
        paperclips.addAutoClipper();
        paperclips.startAutoClippers();


        // wait a couple of seconds to simulate adding thread while thread running
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Factory.setWire(200);
        paperclips.joinAutoClippers();

        assertEquals(1200, factory.getCreatedPaperclips().get());
    }
}
