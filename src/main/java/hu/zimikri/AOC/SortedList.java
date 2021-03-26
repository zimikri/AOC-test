package hu.zimikri.AOC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortedList {

  private List<Integer> sorted;
  
  public SortedList() {
    sorted = new ArrayList<>();
  }

  public boolean add(String data) {
    return add(Integer.parseInt(data));
  }

  public boolean add(Integer data) {
    sorted.add(data);
    Collections.sort(sorted);

    return true;
  }

  public Integer get(int index) {
    return sorted.get(index);
  }

  public Integer getFirst() {
    Integer first = sorted.get(0);
    sorted.remove(0);

    return first;
  }

  public Integer getFirstValue() {
    return sorted.get(0);
  }

  public Integer getLast() {
    Integer last = sorted.get(sorted.size() - 1);
    sorted.remove(sorted.size() - 1);

    return last;
  }

  public Integer getLastValue() {
    return sorted.get(sorted.size() - 1);
  }

  public int size() {
    return sorted.size();
  }
  
  public boolean isEmpty() {
    return sorted.size() == 0;
  }

  public String toString() {
    return sorted.toString();
  }
}
