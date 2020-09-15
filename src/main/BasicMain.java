package main;

import factories.ModelFactory;
import model.BasicModel;
import util.MVCUtil;

public class BasicMain {

	public static void main(String[] args) {
		ModelFactory.setSocialDistancingModel(new BasicModel());
		MVCUtil.startSocialDistancingMVC();
	}

}
