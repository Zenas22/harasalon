import org.sql2o.*;
import java.util.List;

public class Client {
    private String name;
    private int age;
    private String huduma;
    private String email;
    private int id;
    private int stylistid;

    public int getStylistid() {
        return stylistid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHuduma() {
        return huduma;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object otherClient){
        if (!(otherClient instanceof Client)){
            return false;
        } else {
            Client newClient = (Client) otherClient;
            return this.getName().equals(newClient.getName()) &&
                    this.getAge() == newClient.getAge() &&
                    this.getHuduma().equals(newClient.getHuduma()) &&
                    this.getEmail().equals(newClient.getEmail()) &&
                    this.getStylistid() == newClient.getStylistid();
        }
    }

    public Client(String name, int age, String huduma, String email, int stylistid) {
        this.name = name;
        this.age = age;
        this.huduma = huduma;
        this.email = email;
        this.stylistid = stylistid;
    }

    public static List<Client> all(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT id,name,age,huduma,email,stylistid FROM clients;";
            return con.createQuery(sql).executeAndFetch(Client.class);
        }
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO clients (name,age,huduma,email) VALUES (:name,:age,:huduma,:email);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("age", this.age)
                    .addParameter("huduma", this.huduma)
                    .addParameter("email", this.email)
                    .executeUpdate()
                    .getKey();
        }
    }
}