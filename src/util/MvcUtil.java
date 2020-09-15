package util;

import factories.ControllerFactory;
import factories.ModelFactory;
import factories.ViewFactory;

public class MvcUtil {
	
	public static void startSocialDistancingMvc() {
		ModelFactory.getSingleton()
			.addPropertyChangeListener(ViewFactory.getSingleton());
		ControllerFactory.getSingleton().processInput();
	}

}
