import java.util.HashMap;
import java.util.Random;

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
      String displayWinner = "%s is the winner! %s threw %s and %s threw %s.";
      String displayTie = "It's a tie! %s threw %s and %s threw %s.";
      String p1 = "Player One";
      String p2 = "Player Two";
      String throw1 = request.queryParams("player1Choice");
      String throw2 = request.queryParams("player2Choice");
      Integer winner = RockPaperScissors.checkWinner(throw1, throw2);
      if (winner == 1) {
        model.put("winner", String.format(displayWinner, p1, p1, throw1, p2, throw2));
      } else if (winner == 2) {
        model.put("winner", String.format(displayWinner, p2, p1, throw1, p2, throw2));
      } else if (winner == 3) {
        model.put("winner", String.format(displayTie, p1, throw1, p2, throw2));
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

  public static String computerThrow (){
    Random myRandomGenerator = new Random();

    Integer randomNumber = myRandomGenerator.nextInt(3);
    String randomThrow = "";

    if (randomNumber == 0) {
      randomThrow = "Rock";
    } else if (randomNumber == 1) {
      randomThrow = "Scissors";
    } else if (randomNumber == 2) {
      randomThrow = "Paper";
    } else {
      randomThrow = "error";
    }
    return randomThrow;
  }

}
