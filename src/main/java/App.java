import spark.Spark;

import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class App {
    public static void main(String[] args) {
        port(3000);
        staticFiles.location("/public");
        Spark.get("/greet", (req, res) -> "Hello World");
        Spark.get("/greet/:username", (req,res) ->{
            return "Hello " + req.params(":username");
        });
        Spark.post("/greet", (req,res) ->{
          return "Hello " + req.queryParams("username");
        });
        Spark.get("/greet/:username/language/:language", (req,res) ->{
            String name = req.params(":username");
            String lang =  req.params(":language");
            if(lang.equals("Xhosa")){
                return "Molo, " + name;
            }
            if(lang.equals("French")){
                return "Bonjour, " + name;
            }
            if(lang.equals("English")){
                return "Hello, " + name;
            }
            return "nothing";
        });

        //        Spark.get("/", (req, res) -> {
//        };
//        get("/hello/:username", (request, response) -> {
//            return "Hello: " + request.params("username");
//        });
    }
}
