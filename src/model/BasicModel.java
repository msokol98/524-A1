package model;

import util.SocialDistancingUtil;

public class BasicModel extends AbstractModel {

	@Override
	public boolean isSafe() {
		return SocialDistancingUtil.isGivenSafe(distance, duration, exhalationLevel);
	}
	
}
