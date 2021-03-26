package hu.zimikri.AOC;

import java.util.Arrays;
import java.util.Scanner;

public class BridgeCrossing {

  private int fullTimeToCross;
  private SortedList peopleOriginalSide;
  private SortedList peopleOtherSide;

  public BridgeCrossing() {
    peopleOtherSide = new SortedList();
  }

  public Integer getFullTimeToCross() {
    return fullTimeToCross;
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
    peopleOriginalSide = createListFromInput(input);

    if (peopleOriginalSide.size() == 1) {
      fullTimeToCross = peopleOriginalSide.getFirst();
    }

    while (peopleOriginalSide.size() > 1) {
      crossTheBridge();
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
    if (peopleOtherSide.size() % 2 == 0) {
      peopleOtherSide.add(peopleOriginalSide.getFirst());
      fullTimeToCross += peopleOriginalSide.getFirstValue();
      peopleOtherSide.add(peopleOriginalSide.getFirst());
    } else {
      fullTimeToCross += peopleOriginalSide.getLastValue();
      peopleOtherSide.add(peopleOriginalSide.getLast());
      peopleOtherSide.add(peopleOriginalSide.getLast());
    }

    if (!peopleOriginalSide.isEmpty()) {
      fullTimeToCross += peopleOtherSide.getFirstValue();
      peopleOriginalSide.add(peopleOtherSide.getFirst());
    }
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
