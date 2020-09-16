package factory;

import controller.ConsoleSocialDistancingController;
import controller.SocialDistancingController;

public class ControllerFactory {
		
	static SocialDistancingController singleton;

	public static SocialDistancingController getSingleton() {
		if(singleton == null) {
			singleton = new ConsoleSocialDistancingController();
		}
		return singleton;
	}
}
	