import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest{

    @Before
    public void setUp(){
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test","zeus","null");
    }

    @Test
    public void stylist_instantiates(){
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"323206402","zeus@gmail.com");
        assertTrue(testStylist instanceof Stylist);
    }

    @Test
    public void stylist_instantiatesWithFirstName_String(){
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"323206402","zeus@gmail.com");
        assertEquals("Zeus", testStylist.getFirstname());
    }

    @Test
    public void stylist_instantiatesWithLastName_String(){
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"323206402","zeus@gmail.com");
        assertEquals("Dagod", testStylist.getLastname());
    }

    @Test
    public void stylist_instantiatesWithAge_Int(){
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"323206402","zeus@gmail.com");
        assertEquals(25, testStylist.getAge());
    }

    @Test
    public void stylist_instantiatesWithPhoneNumber_Int(){
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"323206402","zeus@gmail.com");
        assertEquals(704832108, testStylist.getPhone());
    }

    @Test
    public void stylist_instantiatesWithHuduma_String(){
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"323206402","zeus@gmail.com");
        assertEquals("32306402", testStylist.getHuduma());
    }

    @Test
    public void stylist_instantiatesWithEmail_String(){
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"323206402","zeus@gmail.com");
        assertEquals("zeus@gmail.com", testStylist.getEmail());
    }

    @After
    public void teardown(){
        try(Connection con = DB.sql2o.open()) {
            String deleteClientsQuery = "DELETE FROM clients *;";
            String deleteStylistsQuery = "DELETE FROM stylists *;";
            con.createQuery(deleteStylistsQuery).executeUpdate();
            con.createQuery(deleteClientsQuery).executeUpdate();
        }
    }

}