package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data.SafeCombination;
import data.SafeCombinations;
import java.util.stream.Stream;
import java.util.Optional;
import static java.util.stream.Collectors.toList;

public class SocialDistancingUtil {
	
	public static boolean isInterpolatedSafe(int distance, int duration, int exhalationLevel) {
		Interpolator intrpl = Interpolator.getInstance();
		return isGivenSafe(intrpl.interpolate(distance));
	}
	
	public static boolean isInterpolatedSafe(int distance, int duration) {
		return isInterpolatedSafe(distance, duration, 0);
	}
	
	public static boolean isInterpolatedSafe(int distance) {
		return isInterpolatedSafe(distance, 0, 0);
	}
	
	public static boolean isGivenSafe(int distance, int duration, int exhalationLevel) {
		List<SafeCombination> safeCombinations = SafeCombinations.getSafeCombinations();
		
		Optional<SafeCombination> givenCombination = 
				safeCombinations
					.stream()
					.filter(comb -> comb.getDistance() == distance && comb.getDuration() == duration && comb.getExhalationLevel() == exhalationLevel)
					.findAny();
		
		return givenCombination.isPresent();
	}
				
	
	public static boolean isDerivedSafe(int distance, int duration, int exhalationLevel) {
		return true;
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
