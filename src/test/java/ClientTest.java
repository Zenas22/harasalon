import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

public class ClientTest{

    @Rule
    public DatabaseRule database = new DatabaseRule();

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
        Client testClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com",1);
        assertTrue(testClient instanceof Client);
    }

    @Test
    public void client_instantiatesWithName_String(){
        Client testClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com",1);
        assertEquals("Stacy", testClient.getName());
    }

    @Test
    public void client_instantiatesWithAge_Int(){
        Client testClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com",1);
        assertEquals(22, testClient.getAge());
    }

    @Test
    public void client_instantiatesWithHuduma_String(){
        Client testClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com",1);
        assertEquals("32306402", testClient.getHuduma());
    }

    @Test
    public void client_instantiatesWithEmail_String(){
        Client testClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com",1);
        assertEquals("stacy@gmail.com", testClient.getEmail());
    }

    @Test
    public void all_returnsAllClients_true(){
        Client oneClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com",1);
        oneClient.save();
        Client twoClient = new Client("Glory",18,"0008989","glory@gmail.com",1);
        twoClient.save();
        assertTrue(Client.all().contains(oneClient));
        assertTrue(Client.all().contains(twoClient));
    }

    @Test
    public void save_true(){
        Client testClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com",1);
        testClient.save();
        assertTrue(Client.all().get(1).equals(testClient));
    }
}