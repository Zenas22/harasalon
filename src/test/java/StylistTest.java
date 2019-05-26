import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

    @Test
    public void newStylist_instantiates() {
        Stylist testStylist = new Stylist(1,"Stacy","Nthenya","stacy@gmail.com",22);
        assertTrue(testStylist instanceof Stylist);
    }

    @Test
    public void newStylist_firstJina_secondJina_baruaPepe_isString() {
        Stylist testStylist = new Stylist(1,"Stacy","Nthenya","stacy@gmail.com",22);
        assertEquals("Stacy", testStylist.getFirstJina());
        assertEquals("Nthenya", testStylist.getSecondJina());
        assertEquals("stacy@gmail.com", testStylist.getBaruaPepe());
    }

    @Test
    public void newStylist_umri_id_isInt() {
        Stylist testStylist = new Stylist(1,"Stacy","Nthenya","stacy@gmail.com",22);
        assertEquals(1, testStylist.getId());
        assertEquals(22, testStylist.getUmri());
    }
}