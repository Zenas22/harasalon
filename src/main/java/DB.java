import org.sql2o.*;

public class DB {
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon", "zeus", "null");

    String connectionString = "jdbc:postgresql://ec2-54-221-214-3.compute-1.amazonaws.com:5432/d15ge4mgdbgcg";
    static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-54-221-214-3.compute-1.amazonaws.com:5432/d15ge4mgdbgcg", "izilsdxgtjhics","bfcf88750b8d2c6d8acc8761f3bb5494bd8b1713e53678d9ffcbfc6550d94bfd");
}