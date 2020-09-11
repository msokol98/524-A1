package util;

import java.util.ArrayList;
import java.util.List;

import data.Combination;
import data.Constants;

public class Interpolator {
	
	private static Interpolator theInterpolator;
	
	private Interpolator() {}
	
	public static Interpolator getInstance() {
		if(theInterpolator == null)
			theInterpolator = new Interpolator();
		return theInterpolator;
	}

	private int interpolateDistance(int distance) {
		List<Integer> distanceConts = new ArrayList<>();
		distanceConts.add(Constants.SMALL_DISTANCE);
		distanceConts.add(Constants.MEDIUM_DISTANCE);
		distanceConts.add(Constants.LARGE_DISTANCE);
		return interpolateLow(distance, distanceConts);
	}
	
	private int interpolateDuration(int duration) {
		List<Integer> durationConts = new ArrayList<>();
		durationConts.add(Constants.SMALL_DURATION);
		durationConts.add(Constants.MEDIUM_DURATION);
		durationConts.add(Constants.LARGE_DURATION);
		return interpolateHigh(duration, durationConts);
	}
	
	public int interpolateExhalationLevel(int exhalationLevel) {
		List<Integer> exhalationLevelConts = new ArrayList<>();
		exhalationLevelConts.add(Constants.SMALL_EXHALATION_LEVEL);
		exhalationLevelConts.add(Constants.MEDIUM_EXHALATION_LEVEL);
		exhalationLevelConts.add(Constants.LARGE_EXHALATION_LEVEL);
		return interpolateHigh(exhalationLevel, exhalationLevelConts);
	}
	
	private int interpolateLow(int value, List<Integer> sortedNums) {
		int largestNum = sortedNums.get(sortedNums.size()-1);
		if(value >= largestNum)
			return largestNum;
		
		int smallestNum = sortedNums.get(0);
		if(value < smallestNum)
			return 0;
		
		int medianIdx = sortedNums.size()/2;
		int median = sortedNums.get(medianIdx);
		int medianPrev = sortedNums.get(medianIdx-1);
		
		if(value >= medianPrev && value < median) 
			return medianPrev;
		
		return -1;
	}
	
	private int interpolateHigh(int value, List<Integer> sortedNums) {
		int largestNum = sortedNums.get(sortedNums.size()-1);
		if(value > largestNum)
			return Integer.MAX_VALUE;
		
		int smallestNum = sortedNums.get(0);
		if(value <= smallestNum)
			return smallestNum;
		
		int medianIdx = sortedNums.size()/2;
		int median = sortedNums.get(medianIdx);
		if(value > sortedNums.get(medianIdx-1) && value <= median) 
			return median;
		
		return -1;
	}

	public Combination interpolate(Combination combination) {
		
		int iDistance = interpolateDistance(combination.getDistance());
		int iDuration = interpolateDuration(combination.getDuration());
		int iExhalationLevel  = interpolateExhalationLevel(combination.getExhalationLevel());
		
		return new Combination(iDistance, iDuration, iExhalationLevel);
	}
	
}
