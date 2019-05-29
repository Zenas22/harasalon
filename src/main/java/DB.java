import org.sql2o.*;

public class DB {
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon", "zeus", "null");

    String connectionString = "jdbc:postgresql://ec2-50-19-254-63.compute-1.amazonaws.com:5432/d1qpct8hjmhbeh";
    Sql2o sql2o = new Sql2o(connectionString, "ezfueykevmjzql","28045ca9513d24d24195cc73bcdfd73b1411cb4e5688727c260fa10104a981d9");
}