package pojo;

/**
 * Plain old Java object that is used by SocialDistancingUtil
 * to make determining safety more readable by grouping together input paramters
 */
public class Combination {
	
	private int distance;
	private int duration;
	private int exhalationLevel;
	
	public Combination(final int aDistance, final int aDuration, final int aExhalationLevel) {
		distance = aDistance;
		duration = aDuration;
		exhalationLevel = aExhalationLevel;
	}

	public int getDistance() {
		return distance;
	}

	public int getDuration() {
		return duration;
	}

	public int getExhalationLevel() {
		return exhalationLevel;
	}
	
	
}