package main;

import factories.ModelFactory;
import model.DerivedModel;
import util.MvcUtil;

public class DerivingMain {

	public static void main(final String[] args) {
		ModelFactory.setSocialDistancingModel(new DerivedModel());
		MvcUtil.startSocialDistancingMvc();
	}

	
}
