import org.junit.*;
import org.junit.Assert.*;
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
}