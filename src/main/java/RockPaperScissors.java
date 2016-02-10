import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class RockPaperScissors {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/roshambo", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/roshambo.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/winner", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      String player1 = request.queryParams("player1Choice");
      String player2 = request.queryParams("player2Choice");
      Integer winner = RockPaperScissors.checkWinner(player1, player2);
      if (winner == 1) {
        model.put("winner", "Player 1 wins");
      } else if (winner == 2) {
        model.put("winner", "Player 2 wins");
      } else if (winner == 3) {
        model.put("winner", "Tie");
      } else if (winner == 4) {
        model.put("winner", "ERROR");
      }
      model.put("template", "templates/winner.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

   }

  public static Integer checkWinner(String player1, String player2) {
    if (player1.equals(player2)) {
      return 3;
    } else if (player1.equals("Rock")) {
      if (player2.equals("Scissors")) {
        return 1;
      } else {
        return 2;
      }
    } else if (player1.equals("Scissors")) {
      if (player2.equals("Rock")){
        return 2;
      } else {
        return 1;
      }
    } else if (player1.equals("Paper")) {
      if (player2.equals("Rock")){
        return 1;
      } else {
        return 2;
      }
    }
    return 4;
  }
}
