import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorTests {

    Factory factory;
    @Before
    public void before(){
        factory = new Factory();
    }
    @Test
    public void canMakeOnePaperclip(){
        //given we have a factory

        //and factory has 1000 wire
        assertEquals(1000, factory.getWire());

        //when we make a paperclip
        factory.makePaperclip();

        //then we should have one createdPaperclip
        assertEquals(1, factory.getCreatedPaperclips());
        // and one unsoldInventory
        assertEquals(1, factory.getUnusedInventory());
        // and 999 wire
        assertEquals(999, factory.getWire());

    }
}
