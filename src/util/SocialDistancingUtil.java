package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import data.Combination;
import data.Constants;
import data.SafeCombinations;
import static java.util.stream.Collectors.toList;

public class SocialDistancingUtil {
	
	public static boolean isInterpolatedSafe(int distance, int duration, int exhalationLevel) {
		Combination givenComb = new Combination(distance, duration, exhalationLevel);
		Combination interpolatedCombination = Interpolator.getInstance().interpolate(givenComb);
		return isGivenSafe(interpolatedCombination.getDistance(), interpolatedCombination.getDuration(), interpolatedCombination.getExhalationLevel());
	}
	
	public static boolean isInterpolatedSafe(int distance, int duration) {
		return isInterpolatedSafe(distance, duration, Constants.MEDIUM_EXHALATION_LEVEL);
	}
	
	public static boolean isInterpolatedSafe(int distance) {
		return isInterpolatedSafe(distance, Constants.MEDIUM_DURATION, Constants.MEDIUM_EXHALATION_LEVEL);
	}
	
	public static boolean isGivenSafe(int distance, int duration, int exhalationLevel) {
		List<Combination> safeCombinations = SafeCombinations.getSafeCombinations();
		
		Optional<Combination> givenCombination = 
				safeCombinations
					.stream()
					.filter(comb -> comb.getDistance() == distance && comb.getDuration() == duration && comb.getExhalationLevel() == exhalationLevel)
					.findAny();
		
		return givenCombination.isPresent();
	}
				
	
	public static boolean isDerivedSafe(int distance, int duration, int exhalationLevel) {
		List<Combination> safeCombinations = SafeCombinations.getSafeCombinations();
		
		Optional<Combination> givenCombination = 
				safeCombinations
					.stream()
					.filter(comb -> comb.getDistance() < distance && comb.getDuration() > duration && comb.getExhalationLevel() > exhalationLevel)
					.findAny();
		
		return givenCombination.isPresent();
	}
	
	public static void printGeneratedCombinationDerivedSafety() {
		int distance = (int) (Math.random() * 50);
		int duration = (int) (Math.random() * 100);
		int exhalationLevel = (int) (Math.random() * 50);
				
		boolean isSafe  = isDerivedSafe(distance, duration, exhalationLevel);
		printCombination(new Combination(distance, duration, exhalationLevel), isSafe);
	}
	
	public static void printGivenAndGeneratedCombinationsDerivedSaftey() {
		System.out.println("Distance, Duration, Exhalation, IsSafe");
		
		List<Combination> safeCombinations = SafeCombinations.getSafeCombinations();
		for(Combination comb : safeCombinations)
			printCombination(comb, true);
		
		System.out.println("---------------");
		
		for(int i = 0; i < 10; i++)
			printGeneratedCombinationDerivedSafety();
	}
	
	private static void printCombination(Combination c, boolean isSafe) {
		System.out.println(c.getDistance() + "," + c.getDuration() + "," + 
							c.getExhalationLevel() + "," + isSafe);
	}
	
	private static List<Combination> getSafeCombsByInterpolatedExhalationLevel(int exhalationLevel) {
		int interpolatedExhalationLevel = 
				Interpolator.getInstance().interpolateExhalationLevel(exhalationLevel);
		
		List<Combination> safeCombinations = SafeCombinations.getSafeCombinations();
		
		return safeCombinations
			.stream()
			.filter(comb -> comb.getExhalationLevel() == interpolatedExhalationLevel)
			.collect(toList());
	}
	
	public static List<Integer[]> generateSafeDistancesAndDurations(int exhalationLevel) {
		List<Integer[]> pairs = new ArrayList<>();
		
		for(Combination c : getSafeCombsByInterpolatedExhalationLevel(exhalationLevel)) 
			pairs.add(new Integer[] {c.getDistance(), c.getDuration()});
		
		return pairs;
	}
	
	public static void printSafeDistancesAndDurations(int exhalationLevel) {
		List<Integer[]> pairs = generateSafeDistancesAndDurations(exhalationLevel);
		
		String pairsStr = "[";
		for(Integer[] pair : pairs)
			pairsStr += "{" + pair[0] + "," + pair[1] + "}";
		pairsStr += "]";
		
		System.out.println(exhalationLevel + "," + pairsStr);
	}
	
	
}
