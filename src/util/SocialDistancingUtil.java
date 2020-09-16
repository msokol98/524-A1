package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import data.Constants;
import data.SafeCombinations;
import factory.ClassifierFactory;
import gradingTools.comp524f20.assignment1.WekaUtil;
import pojo.Combination;

import static java.util.stream.Collectors.toList;

public class SocialDistancingUtil {
	
	public static final String DERIVED = "derived";
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final String COMMA = ",";
	
	/**
	   * The method paramters are interpolated using a helper util class. 
	   * If the return interpolated combination is safe, based on the given data, the
		function returns true. Otherwise, it returns false.
	   */
	public static boolean isInterpolatedSafe(final int distance, final int duration, 
												final int exhalationLevel) {
		final Combination givenComb = new Combination(distance, duration, exhalationLevel);
		final Combination interpolatedCombination = Interpolator.getInstance().interpolate(givenComb);
		return isGivenSafe(interpolatedCombination.getDistance(), interpolatedCombination.getDuration(), interpolatedCombination.getExhalationLevel());
	}
	
	/**
	   * Overloaded method that calls interpolated safe using a default exhalation level.
	   */
	public static boolean isInterpolatedSafe(final int distance, final int duration) {
		return isInterpolatedSafe(distance, duration, Constants.MEDIUM_EXHALATION_LEVEL);
	}
	
	public static boolean isInterpolatedSafe(final int distance) {
		return isInterpolatedSafe(distance, Constants.MEDIUM_DURATION);
	}
	
	/**
	   * If the combination of the method parameters is safe, based on the given data, the
		function returns true. Otherwise, it returns false.
	   */
	public static boolean isGivenSafe(final int distance, final int duration, final int exhalationLevel) {
		final List<Combination> safeCombinations = SafeCombinations.getSafeCombinations();
		
		final Optional<Combination> givenCombination = 
				safeCombinations
					.stream()
					.filter(comb -> comb.getDistance() == distance && comb.getDuration() == duration && comb.getExhalationLevel() == exhalationLevel)
					.findAny();
		
		return givenCombination.isPresent();
	}
				
	
	/**
	   * The method derives whether the given combination is safe by seeing if it is safer than 
	   * at least one of the known safe combinations. If so, then return true. 
		 Otherwise, it returns false
	   */
	public static boolean isDerivedSafe(final int distance, final int duration, final int exhalationLevel) {
		final List<Combination> safeCombinations = SafeCombinations.getSafeCombinations();
		
		final Optional<Combination> givenCombination = 
				safeCombinations
					.stream()
					.filter(comb -> distance >= comb.getDistance() && duration <= comb.getDuration() && exhalationLevel <= comb.getExhalationLevel())
					.findAny();
		
		return givenCombination.isPresent();
	}
	
	public static boolean isInferredSafe(final int distance, final int duration, final int exhalationLevel) {
		final String result = WekaUtil.predictString(ClassifierFactory.getSingleton(), 
							new String[] {"distance", "duration", "exhalationLevel"},
							new double[] {distance, duration, exhalationLevel}, 
							"safe", 
							new String[] {TRUE, FALSE});
		return TRUE.equals(result) ? true : false;
	}
	
	private static int getRandom(final int coefficient) {
		final double offset = 1.09493495934956590359082349023409823409823490823409823409823409530935;
		return (int) (Math.random() * offset * coefficient);
	}
	
	public static void printGeneratedCombinationDerivedSafety() {
		final int distance = getRandom(50);
		final int duration = getRandom(100);
		final int exhalationLevel = getRandom(50);
				
		final boolean isSafe  = isDerivedSafe(distance, duration, exhalationLevel);
		printCombination(new Combination(distance, duration, exhalationLevel), isSafe);
	}
	
	public static void printGeneratedCombinationInferredSafety() {
		final int distance = getRandom(50);
		final int duration = getRandom(100);
		final int exhalationLevel = getRandom(50);
		
		final boolean isSafe  = isInferredSafe(distance, duration, exhalationLevel);
		printCombination(new Combination(distance, duration, exhalationLevel), isSafe);
	}
	
	private static void printGivenAndGeneratedCombinationsSafety(final String type) {
		System.out.println("Distance,Duration,Exhalation,IsSafe");
		
		final List<Combination> safeCombinations = SafeCombinations.getSafeCombinations();
		for(Combination comb : safeCombinations) {
			printCombination(comb, true);
		}
		
		System.out.println("---------------");
		
		printTheCombos(type);
	}
	
	private static void printTheCombos(final String type) {		
		final int count = 10;
		for(int i = 0; i < count; i++) {
			if(type.contentEquals(DERIVED)) {
				printGeneratedCombinationDerivedSafety();
			} else {
				printGeneratedCombinationInferredSafety();
			}
		}
	}
	
	public static void printGivenAndGeneratedCombinationsDerivedSafety() {
		printGivenAndGeneratedCombinationsSafety(DERIVED);
	}
	
	public static void printGivenAndGeneratedCombinationsInferredSafety() {
		printGivenAndGeneratedCombinationsSafety("inferred");
	}
	
	private static void printCombination(final Combination c, final boolean isSafe) {
		System.out.println(c.getDistance() + COMMA + c.getDuration() + COMMA + 
							c.getExhalationLevel() + COMMA + isSafe);
	}
	
	private static void printCombination(final Combination c, final boolean isDerivedSafe, final boolean isInferredSafe) {
		System.out.println(c.getDistance() + COMMA + c.getDuration() + COMMA + 
				c.getExhalationLevel() + COMMA + isDerivedSafe + ',' + isInferredSafe);
	}
	
	private static List<Combination> getSafeCombsByInterpolatedExhalationLevel(final int exhalationLevel) {
		final int interpolatedExhalationLevel = 
				Interpolator.getInstance().interpolateExhalationLevel(exhalationLevel);
		
		final List<Combination> safeCombinations = SafeCombinations.getSafeCombinations();
		
		return safeCombinations
			.stream()
			.filter(comb -> comb.getExhalationLevel() == interpolatedExhalationLevel)
			.collect(toList());
	}
	
	public static List<Integer[]> generateSafeDistancesAndDurations(final int exhalationLevel) {
		final List<Integer[]> pairs = new ArrayList<>();
		
		for(Combination c : getSafeCombsByInterpolatedExhalationLevel(exhalationLevel)) {
			pairs.add(new Integer[] {c.getDistance(), c.getDuration()});
		}
		
		return pairs;
	}
	
	public static void printSafeDistancesAndDurations(final int exhalationLevel) {
		final List<Integer[]> pairs = generateSafeDistancesAndDurations(exhalationLevel);
		
		String pairsStr = "[";
		for(Integer[] pair : pairs) {
			pairsStr += "{" + pair[0] + COMMA + pair[1] + "}";
		}
		pairsStr += "]";
		
		System.out.println(exhalationLevel + COMMA + pairsStr);
	}
	
	public static int compareSafetyComputations() {
		int correct = 0;
		final int count = 10;
		
		System.out.println("Distance,Duration,Exhalation,Derived,Inferred");
		
		for(int i = 0; i < count; i++) {
			final int distance = getRandom(Constants.MEDIUM_DISTANCE);
			final int duration = getRandom(Constants.MEDIUM_DURATION);
			final int exhalationLevel = getRandom(Constants.MEDIUM_EXHALATION_LEVEL);
			
			final boolean derivedSafe = isDerivedSafe(distance, duration, exhalationLevel);
			final boolean inferredSafe = isInferredSafe(distance, duration, exhalationLevel);
			
			if(derivedSafe == inferredSafe) {
				correct++;
			}
			
			final Combination c = new Combination(distance, duration, exhalationLevel);
			printCombination(c, derivedSafe, inferredSafe);
		}
		return correct;
	}
}
