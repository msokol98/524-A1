package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface SocialDistancingView extends PropertyChangeListener {
	void propertyChange(PropertyChangeEvent evt);
}
