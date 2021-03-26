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

  @Test
  public void crossTheBridgeShouldReturnExpectedValue() throws Exception {
    SortedList sortedList = new SortedList();
    sortedList.add(5);
    sortedList.add(10);
    sortedList.add(2);
    sortedList.add(1);

    BridgeCrossing bridgeCrossing = new BridgeCrossing();
    bridgeCrossing.setThisSide(sortedList);

    bridgeCrossing.crossTheBridge();
    Assert.assertEquals("[5, 10]", bridgeCrossing.getThisSide().toString());

    bridgeCrossing.goBack();
    Assert.assertEquals("[1, 5, 10]", bridgeCrossing.getThisSide().toString());

    bridgeCrossing.crossTheBridge();
    Assert.assertEquals("[1]", bridgeCrossing.getThisSide().toString());
  }

  @Test
  public void crossTheBridgeShouldReturnExpectedValue2() throws Exception {
    SortedList sortedList = new SortedList();
    sortedList.add(2);
    sortedList.add(1);
    sortedList.add(2);
    sortedList.add(2);

    BridgeCrossing bridgeCrossing = new BridgeCrossing();
    bridgeCrossing.setThisSide(sortedList);

    bridgeCrossing.crossTheBridge();
    Assert.assertEquals("[2, 2]", bridgeCrossing.getThisSide().toString());

    bridgeCrossing.goBack();
    Assert.assertEquals("[1, 2, 2]", bridgeCrossing.getThisSide().toString());

    bridgeCrossing.crossTheBridge();
    Assert.assertEquals("[2]", bridgeCrossing.getThisSide().toString());
  }
}
