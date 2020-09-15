package factories;

import view.SocialDistancingView;
import view.SocialDistancingViewImpl;

public class ViewFactory {
	
	static SocialDistancingView singleton;
	
	public static SocialDistancingView getSingleton() {
		if(singleton == null) {
			singleton = new SocialDistancingViewImpl();
		}
		return singleton;
	}
		
}
