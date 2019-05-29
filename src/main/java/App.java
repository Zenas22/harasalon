import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App{
    public static void main(String[] args){
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";//add footer
        String index = "templates/index.vtl";

        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", index);
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/stylists",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("stylists", Stylist.all());
            model.put("template", "templates/stylists.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("stylists", Stylist.all());
            model.put("template","templates/form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/stylists", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String firstname = request.queryParams("firstname");
            String lastname = request.queryParams("lastname");
            int age = Integer.parseInt(request.queryParams("age"));
            int phone = Integer.parseInt(request.queryParams("phone"));
            String huduma = request.queryParams("huduma");
            String email = request.queryParams("email");
            Stylist newStylist = new Stylist(firstname,lastname,age,phone,huduma,email);
            newStylist.save();
            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/stylists/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
            model.put("stylist", stylist);
            model.put("clients", Client.all());
            model.put("template", "templates/stylist.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}