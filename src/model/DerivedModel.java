package model;

import util.SocialDistancingUtil;

public class DerivedModel extends AbstractModel {
	
	@Override
	public boolean isSafe() {
		return SocialDistancingUtil.isDerivedSafe(distance, duration, exhalationLevel);
	}

}
