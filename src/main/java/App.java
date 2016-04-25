import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Object;
import java.lang.String;
import spark.ModelAndView;
import static java.lang.System.out;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      double inputLength = Double.parseDouble(request.queryParams("length"));
      double inputWidth = Double.parseDouble(request.queryParams("width"));
      double inputHeight = Double.parseDouble(request.queryParams("height"));
      double inputWeight = Double.parseDouble(request.queryParams("weight"));
      int inputDel = Integer.parseInt(request.queryParams("delivery"));

      Parcels par = new Parcels(inputLength, inputWidth, inputHeight, inputWeight, inputDel);
      double price = par.getPrice();
      BigDecimal bd = new BigDecimal(price).setScale(2, RoundingMode.HALF_EVEN);

      model.put("bd", bd);
      // model.put("inputSide1", inputSide1);
      // model.put("inputSide2", inputSide2);
      // model.put("inputSide3", inputSide3);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
