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
}