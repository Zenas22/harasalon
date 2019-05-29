import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
//import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App{
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args){
        port(getHerokuAssignedPort());
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

        post("/stylists/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
            stylist.delete();
            model.put("stylists", Stylist.all());
            model.put("template", "templates/stylists.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/stylists/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
            String firstname = request.queryParams("firstname");
            String lastname = request.queryParams("lastname");
            int age = Integer.parseInt(request.queryParams("age"));
            int phone = Integer.parseInt(request.queryParams("phone"));
            String huduma = request.queryParams("huduma");
            String email = request.queryParams("email");
            stylist.update(firstname,lastname,age,phone,huduma,email);
            String url = String.format("/stylists/%d", stylist.getId());
            response.redirect(url);
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/clients", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("clients", Client.all());
            model.put("template", "templates/clients.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/client-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("stylists", Stylist.all());
            model.put("clients", Client.all());
            model.put("template", "templates/client-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/clients", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Stylist stylist = Stylist.find(Integer.parseInt(request.queryParams("stylistid")));
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String huduma = request.queryParams("huduma");
            String email = request.queryParams("email");
            Client client = new Client(name,age,huduma,email,stylist.getId());
            client.save();
            model.put("stylists", Stylist.all());
            model.put("stylist", stylist);
            model.put("client", client);
            model.put("clients", Client.all());
            model.put("template", "templates/clients.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/clients/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Client client = Client.find(Integer.parseInt(request.params("id")));
            model.put("stylists", Stylist.all());
            model.put("client", client);
            model.put("template", "templates/client.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/clients/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Stylist stylist = Stylist.find(Integer.parseInt(request.queryParams("stylistid")));
            Client client = Client.find(Integer.parseInt(request.params(":id")));
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String huduma = request.queryParams("huduma");
            String email = request.queryParams("email");
            client.update(name,age,huduma,email,stylist.getId());
            String url = String.format("/clients/%d", client.getId());
            response.redirect(url);
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/clients/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Client client = Client.find(Integer.parseInt(request.params(":id")));
            client.delete();
            model.put("clients", Client.all());
            model.put("template", "templates/clients.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}