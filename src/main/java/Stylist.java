import org.sql2o.Sql2o;
import org.sql2o.Connection;

import java.util.List;

public class Stylist{
    private String firstname;
    private String lastname;
    private int age;
    private int phone;
    private String huduma;
    private String email;
    private int id;

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public int getPhone() {
        return phone;
    }

    public String getHuduma() {
        return huduma;
    }

    public String getEmail() {
        return email;
    }

    public Stylist(String firstname, String lastname, int age, int phone, String huduma, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.huduma = huduma;
        this.email = email;
    }

    @Override
    public boolean equals(Object otherStylist){
        if(!(otherStylist instanceof Stylist)){
            return false;
        } else {
            Stylist newStylist = (Stylist) otherStylist;
            return this.getFirstname().equals(newStylist.getFirstname()) &&
                    this.getLastname().equals(newStylist.getLastname()) &&
                    this.getAge() == newStylist.getAge() &&
                    this.getPhone() == newStylist.getPhone() &&
                    this.getHuduma().equals(newStylist.getHuduma()) &&
                    this.getEmail().equals(newStylist.getEmail());
        }
    }

    public static List<Stylist> all(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM stylists;";
            return con.createQuery(sql).executeAndFetch(Stylist.class);
        }
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO stylists (firstname, lastname, age, phone, huduma, email) VALUES (:firstname, :lastname, :age, :phone, :huduma, :email)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("firstname", firstname)
                    .addParameter("lastname", lastname)
                    .addParameter("age", age)
                    .addParameter("phone", phone)
                    .addParameter("huduma", huduma)
                    .addParameter("email", email)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static Stylist find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM stylists WHERE id= :id";
            Stylist stylist = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Stylist.class);
            return stylist;
        }
    }

    public void update(String firstname, String lastname, int age, int phone, String huduma, String email){
        try(Connection con = DB.sql2o.open()){
            String sql = "UPDATE stylists SET firstname= :firstname, lastname= :lastname, age= :age, phone= :phone, huduma= :huduma, email= :email";
            con.createQuery(sql)
                    .addParameter("firstname", firstname)
                    .addParameter("lastname", lastname)
                    .addParameter("age", age)
                    .addParameter("phone", phone)
                    .addParameter("huduma", huduma)
                    .addParameter("email", email)
                    .executeUpdate();
        }
    }

    public List<Client> getClients(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM clients WHERE stylistid=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Client.class);
        }
    }

    public void delete(){
        try(Connection con = DB.sql2o.open()){
            String deleteStylist = "DELETE FROM stylists WHERE id= :id";
            String deleteClients = "DELETE FROM clients WHERE stylistid = :id";
            con.createQuery(deleteStylist)
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(deleteClients)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

}