package main;

import factory.ModelFactory;
import model.BasicModel;
import util.MvcUtil;

public class BasicMain {

	public static void main(final String[] args) {
		ModelFactory.setSocialDistancingModel(new BasicModel());
		MvcUtil.startSocialDistancingMvc();
	}

}
