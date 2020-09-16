package main;

import factory.ModelFactory;
import model.InterpolatingModel;
import util.MvcUtil;

public class InterpolatingMain {
	
	public static void main(final String[] args) {
		ModelFactory.setSocialDistancingModel(new InterpolatingModel());
		MvcUtil.startSocialDistancingMvc();
	}

}
