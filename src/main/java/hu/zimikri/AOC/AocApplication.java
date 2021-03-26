package hu.zimikri.AOC;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AocApplication {

	public static void main(String[] args) {

		// Run with given example data
		try {
			BridgeCrossing bridgeCrossing = new BridgeCrossing();

      System.out.println("Whith given data [10, 5, 2, 1]:");
			System.out.println(bridgeCrossing.findShortestTime("10, 5, 2, 1").toString());
      System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Read data from console
		try {
			BridgeCrossing bridgeCrossing = new BridgeCrossing();
			System.out.println(bridgeCrossing.findShortestTime().toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
