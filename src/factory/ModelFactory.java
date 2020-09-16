package factory;

import model.BasicModel;
import model.SocialDistancingModel;

public class ModelFactory {
		
	static SocialDistancingModel singleton;
	
	public static SocialDistancingModel getSingleton() {
		if(singleton == null) {
			singleton = new BasicModel();
		}
		return singleton;
	}
	
	public static void setSocialDistancingModel(final SocialDistancingModel model) {
		singleton = model;
	}
	
}
