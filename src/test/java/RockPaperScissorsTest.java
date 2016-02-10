import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.*;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;

public class RockPaperScissorsTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void checkWinner_playersChooseSameThrow_tie() {
    RockPaperScissors testApp = new RockPaperScissors();
    Integer three = 3;
    assertEquals(three, testApp.checkWinner("Rock", "Rock"));
  }
  @Test
  public void checkWinner_rockBeatsScissors_true() {
    RockPaperScissors testApp = new RockPaperScissors();
    Integer one = 1;
    assertEquals(one, testApp.checkWinner("Rock", "Scissors"));
  }


  // @Test
  // public void rootTest() {
  //     goTo("http://localhost:4567/");
  //     assertThat(pageSource()).contains("Leap year detector");
  // }
}
