package main;

import factories.ModelFactory;
import model.InferredModel;
import util.MvcUtil;

public class InferringMain {
	
	public static void main(final String[] args) {
		ModelFactory.setSocialDistancingModel(new InferredModel());
		MvcUtil.startSocialDistancingMvc();
	}
	
}
