package util;

import factory.ControllerFactory;
import factory.ModelFactory;
import factory.ViewFactory;

public class MvcUtil {
	
	public static void startSocialDistancingMvc() {
		ModelFactory.getSingleton()
			.addPropertyChangeListener(ViewFactory.getSingleton());
		ControllerFactory.getSingleton().processInput();
	}

}
