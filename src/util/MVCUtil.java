package util;

import factories.ControllerFactory;
import factories.ModelFactory;
import factories.ViewFactory;

public class MVCUtil {
	
	public static void startSocialDistancingMVC() {
		ModelFactory.getSocialDistancingModel()
			.addPropertyChangeListener(ViewFactory.getSocialDistancingView());
		ControllerFactory.getSocialDistancingController().processInput();
	}

}
