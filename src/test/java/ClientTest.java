import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

public class ClientTest{

    @Before
    public void setUp(){
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "zeus", "null");
    }

    @After
    public void tearDown(){
        try(Connection con = DB.sql2o.open()){
            String deleteClientsql = "DELETE FROM clients *;";
            String deleteStylistsql = "DELETE FROM stylists *;";
            con.createQuery(deleteClientsql).executeUpdate();
            con.createQuery(deleteStylistsql).executeUpdate();
        }
    }

    @Test
    public void client_instantiates_true(){
        Client testClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com");
        assertTrue(testClient instanceof Client);
    }

    @Test
    public void client_instantiatesWithName_String(){
        Client testClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com");
        assertEquals("Stacy", testClient.getName());
    }

    @Test
    public void client_instantiatesWithAge_Int(){
        Client testClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com");
        assertEquals(22, testClient.getAge());
    }

    @Test
    public void client_instantiatesWithHuduma_String(){
        Client testClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com");
        assertEquals("32306402", testClient.getHuduma());
    }

    @Test
    public void client_instantiatesWithEmail_String(){
        Client testClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com");
        assertEquals("stacy@gmail.com", testClient.getEmail());
    }
}