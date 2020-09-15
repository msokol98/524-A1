package model;

import util.SocialDistancingUtil;

public class InterpolatingModel extends AbstractModel {

	@Override
	public boolean isSafe() {
		return SocialDistancingUtil.isInterpolatedSafe(distance, duration, exhalationLevel);
	}

}
