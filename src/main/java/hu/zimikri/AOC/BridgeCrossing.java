package hu.zimikri.AOC;

import java.util.Scanner;

public class BridgeCrossing {

  private int fullTimeToCross;
  private SortedList thisSide;
  private SortedList otherSide;

  public BridgeCrossing() {
    otherSide = new SortedList();
  }

  public Integer getFullTimeToCross() {
    return fullTimeToCross;
  }

  public SortedList getThisSide() {
    return thisSide;
  }

  public SortedList getOtherSide() {
    return otherSide;
  }

  public void setThisSide(SortedList thisSide) {
    this.thisSide = thisSide;
  }

  public String loadDataFromConsole() {
    System.out.println("Add comma/space separated integers (time to get to the other side)!");

    Scanner in = new Scanner(System.in);
    String input = in.nextLine();
    in.close();

    return input;
  }

  public BridgeCrossing findShortestTime() throws Exception {
    return findShortestTime(loadDataFromConsole());
  }

  public BridgeCrossing findShortestTime(String input) throws Exception {
    validateInput(input);
    thisSide = createListFromInput(input);

    if (thisSide.size() == 1) {
      fullTimeToCross = thisSide.getFirst();
    }

    while (thisSide.size() > 1) {
      crossTheBridge();
      if (!thisSide.isEmpty()) {
        goBack();
      }
    }

    return this;
  }

  public SortedList createListFromInput(String input) {
    SortedList sortedList = new SortedList();
    for (String time : input.split("[ ,]+")) {
      sortedList.add(time);
    }

    return sortedList;
  }

  private void crossTheBridge() {
    if (otherSide.size() == 0
        || thisSide.size() == 2
        || otherSide.getFirstValue() >= thisSide.get(1)) {
      otherSide.add(thisSide.getFirst());
      fullTimeToCross += thisSide.getFirstValue();
      otherSide.add(thisSide.getFirst());

      return;
    }

    Integer otherSideQuickest = otherSide.getFirstValue();
    Integer thisSideQuickest = thisSide.getFirstValue();
    Integer thisSideSlowest = thisSide.getLastValue();
    Integer thisSide2ndSlowest = thisSide.get(thisSide.size() - 2);

    fullTimeToCross += thisSideSlowest;
    otherSide.add(thisSide.getLast());
    if (thisSideQuickest + thisSide2ndSlowest > 2 * otherSideQuickest) {
      otherSide.add(thisSide.getLast());
    } else {
      otherSide.add(thisSide.getFirst());
    }

  }

  public void goBack() {
    fullTimeToCross += otherSide.getFirstValue();
    thisSide.add(otherSide.getFirst());
  }

  public boolean validateInput(String input) throws Exception {
    if (!input.trim().matches("[0-9 ,]+")) {
      throw new Exception("Invalid input");
    }

    return true;
  }

  @Override
  public String toString() {
    return "The shortest time is " + fullTimeToCross + " minutes.";
  }
}
