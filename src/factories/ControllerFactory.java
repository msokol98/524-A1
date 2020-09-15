package factories;

import controller.ConsoleSocialDistancingController;
import controller.SocialDistancingController;

public class ControllerFactory {
		
	static SocialDistancingController singleton;

	public static SocialDistancingController getSocialDistancingController() {
		if(singleton == null)
			singleton = new ConsoleSocialDistancingController();
		return singleton;
	}
}
	