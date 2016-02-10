import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class RockPaperScissors {
  public static void main(String[] args) {  }

  public Integer checkWinner(String player1, String player2) {
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
