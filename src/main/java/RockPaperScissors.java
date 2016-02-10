import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class RockPaperScissors {
  public static void main(String[] args) {  }

  public Integer checkWinner(String player1, String player2) {
    if (player1.equals(player2)) {
      return 3;
    }
    return 4;
  }
}
