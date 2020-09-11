package util;

import data.Combination;

public class Interpolator {
	
	private static Interpolator theInterpolator;
	
	private Interpolator() {}
	
	public static Interpolator getInstance() {
		if(theInterpolator == null)
			theInterpolator = new Interpolator();
		return theInterpolator;
	}

	private int interpolateDistance(int distance) {
		return distance;
	}
	
	private int interpolateDuration(int duration) {
		return duration;
	}
	
	private int interpolateExhalationLevel(int exhalationLevel) {
		return exhalationLevel;
	}

	public Combination interpolate(Combination combination) {
		
		int iDistance = interpolateDistance(combination.getDistance());
		int iDuration = interpolateDuration(combination.getDuration());
		int iExhalationLevel  = interpolateExhalationLevel(combination.getExhalationLevel());
		
		return new Combination(iDistance, iDuration, iExhalationLevel);
	}
	
}
