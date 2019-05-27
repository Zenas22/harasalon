public class Client {
    private String name;
    private int age;
    private String huduma;
    private String email;
    private int id;

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
                    this.getEmail().equals(newClient.getEmail());
        }
    }

    public Client(String name, int age, String huduma, String email) {
        this.name = name;
        this.age = age;
        this.huduma = huduma;
        this.email = email;
    }
}