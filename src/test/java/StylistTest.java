import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

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
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"32306402","zeus@gmail.com");
        assertEquals("32306402", testStylist.getHuduma());
    }

    @Test
    public void stylist_instantiatesWithEmail_String(){
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"323206402","zeus@gmail.com");
        assertEquals("zeus@gmail.com", testStylist.getEmail());
    }

    @Test
    public void all_returnsAllInstancesOfStylists_true(){
        Stylist oneStylist = new Stylist("Zeus","Dagod",25,704832108,"323206402","zeus@gmail.com");
        oneStylist.save();
        Stylist twoStylist = new Stylist("Lord", "Doyo", 21,790710855,"27536384","lorddoyo@gmail.com");
        twoStylist.save();
        assertTrue(Stylist.all().contains(oneStylist));
        assertTrue(Stylist.all().contains(twoStylist));
    }

    @Test
    public void save_true(){
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"323206402","zeus@gmail.com");
        testStylist.save();
        assertTrue(Stylist.all().get(0).equals(testStylist));
    }

    @Test
    public void find_returnStylistsWithSameId_true(){
        Stylist oneStylist = new Stylist("Zeus","Dagod",25,704832108,"323206402","zeus@gmail.com");
        oneStylist.save();
        Stylist twoStylist = new Stylist("Lord", "Doyo", 21,790710855,"27536384","lorddoyo@gmail.com");
        twoStylist.save();
        assertEquals(twoStylist, Stylist.find(twoStylist.getId()));
    }

    @Test
    public void update_updatesStylistDetails(){
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"32306402","zeus@gmail.com");
        testStylist.save();
        testStylist.update("Zenas","Dagod",25,777832108,"32306402","zenas@gmail.com");
        Stylist updated = new Stylist("Zenas","Dagod",25,777832108,"32306402","zenas@gmail.com");
        assertEquals(updated.getFirstname(), Stylist.find(testStylist.getId()).getFirstname());
        assertEquals(updated.getLastname(), Stylist.find(testStylist.getId()).getLastname());
        assertEquals(updated.getAge(), Stylist.find(testStylist.getId()).getAge());
        assertEquals(updated.getPhone(), Stylist.find(testStylist.getId()).getPhone());
        assertEquals(updated.getHuduma(), Stylist.find(testStylist.getId()).getHuduma());
        assertEquals(updated.getEmail(), Stylist.find(testStylist.getId()).getEmail());
    }

    @Test
    public void get_returnsAllClientsForStylist(){
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"32306402","zeus@gmail.com");
        testStylist.save();
        Client oneClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com", testStylist.getId());
        oneClient.save();
        Client twoClient = new Client("Glory",18,"0008989","glory@gmail.com",testStylist.getId());
        twoClient.save();
        Client[] clients = new Client[] {oneClient,twoClient};
        assertTrue(testStylist.getClients().containsAll(Arrays.asList(clients)));
    }

    @Test
    public void delete_removesStylistsAndClients(){
        Stylist testStylist = new Stylist("Zeus","Dagod",25,704832108,"32306402","zeus@gmail.com");
        testStylist.save();
        Client oneClient = new Client("Stacy", 22, "32306402", "stacy@gmail.com", testStylist.getId());
        oneClient.save();
        Client twoClient = new Client("Glory",18,"0008989","glory@gmail.com",testStylist.getId());
        twoClient.save();
        int stylistid = testStylist.getId();
        int oneClientid = oneClient.getId();
        int twoClientid = twoClient.getId();
        testStylist.delete();
        assertEquals(null, Stylist.find(stylistid));
        assertEquals(null, Client.find(oneClientid));
        assertEquals(null, Client.find(twoClientid));
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