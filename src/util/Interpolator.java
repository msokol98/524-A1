package util;

public class Interpolator {
	
	private static Interpolator theInterpolator;
	
	private Interpolator() {}
	
	public static Interpolator getInstance() {
		if(theInterpolator == null)
			theInterpolator = new Interpolator();
		return theInterpolator;
	}

	public int interpolateDistance(int distance) {
		return distance;
	}
	
	public int interpolateDuration(int duration) {
		return duration;
	}
	
	public int interpolateExhalationLevel(int exhalationLevel) {
		return exhalationLevel;
	}
	
}
