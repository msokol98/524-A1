package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


abstract public class AbstractModel implements SocialDistancingModel {

	private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	protected int distance;
	protected int duration;
	protected int exhalationLevel;
	protected boolean safe;
		
	public int getDistance() {
		return distance;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public int getExhalationLevel() {
		return exhalationLevel;
	}
	
	public abstract boolean isSafe();
	
	public void setInput(final int aDistance, final int aDuration, final int anExhalationLevel) {
		final int oldDistance = distance;
		final int oldDuration = duration;
		final int oldExhalationLevel = exhalationLevel;
		final Boolean oldSafe = safe;
		
		distance = aDistance;
		duration = aDuration;
		exhalationLevel = anExhalationLevel;
		safe = isSafe();
		
		propertyChangeSupport.firePropertyChange(DISTANCE, null, distance);
		propertyChangeSupport.firePropertyChange(DURATION, null, duration);
		propertyChangeSupport.firePropertyChange(EXHALATION_LEVEL, null, exhalationLevel);
		propertyChangeSupport.firePropertyChange(SAFE, null, safe);
	}
	
	
	@Override
	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}
	
}
