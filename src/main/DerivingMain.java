package main;

import factories.ModelFactory;
import model.DerivedModel;
import util.MVCUtil;

public class DerivingMain {

	public static void main(String[] args) {
		ModelFactory.setSocialDistancingModel(new DerivedModel());
		MVCUtil.startSocialDistancingMVC();
	}

}
