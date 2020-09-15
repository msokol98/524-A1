package factories;

import model.BasicModel;
import model.SocialDistancingModel;

public class ModelFactory {
		
	static SocialDistancingModel singleton;
	
	public static SocialDistancingModel getSocialDistancingModel() {
		if(singleton == null)
			singleton = new BasicModel();
		return singleton;
	}
	
	public static void setSocialDistancingModel(SocialDistancingModel model) {
		singleton = model;
	}
	
}
