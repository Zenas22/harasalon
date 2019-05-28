import static spark.Spark.staticFileLocation;

public class App{
    public static void main(String[] args){
        staticFileLocation("/public");
        String layout = "temlates/layout.vtl";
        String index = "templates/index.vtl";
    }
}