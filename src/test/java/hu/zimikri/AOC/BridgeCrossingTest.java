package hu.zimikri.AOC;

import org.junit.Test;
import org.junit.Assert;

public class BridgeCrossingTest {

  @Test
  public void validateInputShouldReturnTrueIfInputIsValid() throws Exception {
    String input = "  2 3  4 66";
    BridgeCrossing bridgeCrossing = new BridgeCrossing();
    Assert.assertTrue(bridgeCrossing.validateInput(input));
  }

  @Test(expected = Exception.class)
  public void validateInputShouldThrowExceptionIfInputIsInvalid() throws Exception {
    String input = "  2 3 a 4 66";
    BridgeCrossing bridgeCrossing = new BridgeCrossing();
    bridgeCrossing.validateInput(input);
  }

  @Test(expected = Exception.class)
  public void validateInputShouldThrowExceptionIfInputHasNoNumericValue() throws Exception {
    String input = "   ";
    BridgeCrossing bridgeCrossing = new BridgeCrossing();
    bridgeCrossing.validateInput(input);
  }

  @Test(expected = Exception.class)
  public void validateInputShouldThrowExceptionIfInputIsEmpty() throws Exception {
    String input = "";
    BridgeCrossing bridgeCrossing = new BridgeCrossing();
    bridgeCrossing.validateInput(input);
  }
}
