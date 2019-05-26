import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

    @Test
    public void newStylist_instantiates() {
        Stylist testStylist = new Stylist(1,"Stacy","Nthenya","stacy@gmail.com",22);
        assertTrue(testStylist instanceof Stylist);
    }
}