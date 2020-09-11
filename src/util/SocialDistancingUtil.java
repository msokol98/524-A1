package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import data.Combination;
import data.SafeCombinations;

public class SocialDistancingUtil {
	
	public static boolean isInterpolatedSafe(int distance, int duration, int exhalationLevel) {
		Combination givenComb = new Combination(distance, duration, exhalationLevel);
		Combination interpolatedCombination = Interpolator.getInstance().interpolate(givenComb);
		return isGivenSafe(interpolatedCombination.getDistance(), interpolatedCombination.getDuration(), interpolatedCombination.getExhalationLevel());
	}
	
	public static boolean isInterpolatedSafe(int distance, int duration) {
		return isInterpolatedSafe(distance, duration, 0);
	}
	
	public static boolean isInterpolatedSafe(int distance) {
		return isInterpolatedSafe(distance, 0, 0);
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
		int distance = (int) Math.random();
		int duration = (int) Math.random();
		int exhalationLevel = (int) Math.random();
		boolean isSafe  = isDerivedSafe(distance, duration, exhalationLevel);
		
		System.out.println(distance + "," + duration + "," + exhalationLevel + "," + isSafe);
	}
	
	public static void printGivenAndGeneratedCombinationsDerivedSaftey() {
		for(int i = 0; i < 10; i++)
			printGeneratedCombinationDerivedSafety();
	}
	
	public static List<Integer[]> generateSafeDistancesAndDurations(int exhalationLevel) {
		List<Integer[]> pairs = new ArrayList<>();
		return pairs;
	}
	
	public static void printSafeDistancesAndDurations(int exhalationLevel) {
		List<Integer[]> pairs = generateSafeDistancesAndDurations(exhalationLevel);
		System.out.println(exhalationLevel + "," + pairs.toString());
	}
	
	
}
