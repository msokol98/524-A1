package view;

import java.beans.PropertyChangeEvent;

import model.SocialDistancingModel;

public class SocialDistancingViewImpl implements SocialDistancingView {

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.toString());
		if(evt.getPropertyName() == SocialDistancingModel.SAFE) {
			Boolean safe = (Boolean) evt.getNewValue();
			String output = safe ? "Safe" : "Not Safe!";
			System.out.println(output);
		}
		
	}

}
