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
    public

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