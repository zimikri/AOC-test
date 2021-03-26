package hu.zimikri.AOC;

import org.junit.Assert;
import org.junit.Test;

public class BridgeCrossingIT {

  BridgeCrossing bridgeCrossing;

  @Test
  public void findShortestTimeShouldReturnExpectedValue() throws Exception {
    String input = "10 5 2 1";
    bridgeCrossing = new BridgeCrossing();
    Integer actual = bridgeCrossing.findShortestTime(input).getFullTimeToCross();
    Integer expected = 17;

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void findShortestTimeShouldReturnGivenValueWhenWeHaveOneElement() throws Exception {
    String input = "10";
    bridgeCrossing = new BridgeCrossing();
    Integer actual = bridgeCrossing.findShortestTime(input).getFullTimeToCross();
    Integer expected = Integer.parseInt(input);

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void findShortestTimeShouldReturnBiggerValueWhenWeHaveTwoElements() throws Exception {
    String input = "10 5";
    bridgeCrossing = new BridgeCrossing();
    Integer actual = bridgeCrossing.findShortestTime(input).getFullTimeToCross();
    Integer expected = 10;

    Assert.assertEquals(expected, actual);
  }

  @Test(expected = Exception.class)
  public void findShortestTimeShouldThrowExceptionIfInputIsInvalid() throws Exception {
    String input = "2 3 a 4 66";
    bridgeCrossing = new BridgeCrossing();
    bridgeCrossing.findShortestTime(input);
  }
}
