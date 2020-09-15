package model;

import java.beans.PropertyChangeListener;

public interface SocialDistancingModel {
	
	public static final String DISTANCE = "distance";
	public static final String DURATION = "duration";
	public static final String EXHALATION_LEVEL = "exhalationLevel";
	public static final String SAFE = "safe";
	
	int getDistance();
	int getDuration();
	int getExhalationLevel();
	boolean isSafe();
	
	void setInput(int distance, int duration, int exhalationLevel);
	void addPropertyChangeListener(PropertyChangeListener listener);
	
}
