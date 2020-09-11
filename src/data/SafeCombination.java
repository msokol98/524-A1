package data;

public class SafeCombination {
	
	private int distance;
	private int duration;
	private int exhalationLevel;
	
	public SafeCombination(int distance, int duration, int exhalationLevel) {
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