package data;

public class Combination {
	
	private int distance;
	private int duration;
	private int exhalationLevel;
	
	public Combination(int distance, int duration, int exhalationLevel) {
		this.distance = distance;
		this.duration = duration;
		this.exhalationLevel = exhalationLevel;
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