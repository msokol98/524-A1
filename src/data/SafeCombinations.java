package data;

import java.util.ArrayList;
import java.util.List;

import pojo.Combination;

import static java.util.stream.Collectors.toList;
/**
 * This class contains all of the concrete, safe combinations
 * as outlined in Table 2 of the assignment.
 */
public class SafeCombinations {
	
	private static List<Combination> combinations;
		
	public static List<Combination> getSafeCombinations() {
		if(combinations == null) {
			generateCombinations();
		}
		return combinations.stream().collect(toList());
	}
	
	private static void generateCombinations() {
		combinations = new ArrayList<>();
		combinations.add(new Combination(
				Constants.MEDIUM_DISTANCE, Constants.MEDIUM_DURATION, Constants.MEDIUM_EXHALATION_LEVEL));
		
		combinations.add(new Combination(
				Constants.SMALL_DISTANCE, Constants.MEDIUM_DURATION, Constants.SMALL_EXHALATION_LEVEL));
		
		combinations.add(new Combination(
				Constants.LARGE_DISTANCE, Constants.MEDIUM_DURATION, Constants.LARGE_EXHALATION_LEVEL));
		
		combinations.add(new Combination(
				Constants.MEDIUM_DISTANCE, Constants.SMALL_DURATION, Constants.LARGE_EXHALATION_LEVEL));
		
		combinations.add(new Combination(
				Constants.MEDIUM_DISTANCE, Constants.LARGE_DURATION, Constants.SMALL_EXHALATION_LEVEL));
		
		combinations.add(new Combination(
				Constants.LARGE_DISTANCE, Constants.LARGE_DURATION, Constants.MEDIUM_EXHALATION_LEVEL));
		
		combinations.add(new Combination(
				Constants.SMALL_DISTANCE, Constants.SMALL_DURATION, Constants.MEDIUM_EXHALATION_LEVEL));
	}
	
}


