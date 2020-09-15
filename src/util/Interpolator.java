package util;

import java.util.ArrayList;
import java.util.List;

import data.Combination;
import data.Constants;

public class Interpolator {
	
	private static Interpolator theInterpolator;
	
	private Interpolator() {}
	
	public static Interpolator getInstance() {
		if(theInterpolator == null) {
			theInterpolator = new Interpolator();
		}
		return theInterpolator;
	}

	private int interpolateDistance(final int distance) {
		final List<Integer> distanceConts = new ArrayList<>();
		distanceConts.add(Constants.SMALL_DISTANCE);
		distanceConts.add(Constants.MEDIUM_DISTANCE);
		distanceConts.add(Constants.LARGE_DISTANCE);
		return interpolateLow(distance, distanceConts);
	}
	
	private int interpolateDuration(final int duration) {
		final List<Integer> durationConts = new ArrayList<>();
		durationConts.add(Constants.SMALL_DURATION);
		durationConts.add(Constants.MEDIUM_DURATION);
		durationConts.add(Constants.LARGE_DURATION);
		return interpolateHigh(duration, durationConts);
	}
	
	public int interpolateExhalationLevel(final int exhalationLevel) {
		final List<Integer> exhalationLevelConts = new ArrayList<>();
		exhalationLevelConts.add(Constants.SMALL_EXHALATION_LEVEL);
		exhalationLevelConts.add(Constants.MEDIUM_EXHALATION_LEVEL);
		exhalationLevelConts.add(Constants.LARGE_EXHALATION_LEVEL);
		return interpolateHigh(exhalationLevel, exhalationLevelConts);
	}
	
	private int interpolateLow(final int value, final List<Integer> sortedNums) {
		final int largestNum = sortedNums.get(sortedNums.size()-1);
		if(value >= largestNum) {
			return largestNum;
		}
		
		final int smallestNum = sortedNums.get(0);
		if(value < smallestNum) {
			return 0;
		}
		
		for(int m = 1; m <= sortedNums.size(); m++) {
			if(value >= sortedNums.get(m-1) && value < sortedNums.get(m)) {
				return sortedNums.get(m-1);
			}
		}
		
		return -1;
	}
	
	private int interpolateHigh(final int value, final List<Integer> sortedNums) {
		final int largestNum = sortedNums.get(sortedNums.size()-1);
		if(value > largestNum) {
			return Integer.MAX_VALUE;
		}
		
		final int smallestNum = sortedNums.get(0);
		if(value <= smallestNum) {
			return smallestNum;
		}
		
		for(int m = 1; m <= sortedNums.size(); m++) {
			if(value > sortedNums.get(m-1) && value <= sortedNums.get(m)) {
				return sortedNums.get(m);
			}
		}
		
		return -1;
	}

	public Combination interpolate(final Combination combination) {
		
		final int iDistance = interpolateDistance(combination.getDistance());
		final int iDuration = interpolateDuration(combination.getDuration());
		final int iExhalationLevel  = interpolateExhalationLevel(combination.getExhalationLevel());
		
		return new Combination(iDistance, iDuration, iExhalationLevel);
	}
	
}
