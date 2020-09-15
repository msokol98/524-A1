package main;

import factories.ModelFactory;
import model.InterpolatingModel;
import util.MVCUtil;

public class InterpolatingMain {
	
	public static void main(String[] args) {
		ModelFactory.setSocialDistancingModel(new InterpolatingModel());
		MVCUtil.startSocialDistancingMVC();
	}

}
