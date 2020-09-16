package model;

import util.SocialDistancingUtil;

/**
 * This model is used when we determine safety
 * based on an interpolation of the given parameters
 */
public class InterpolatingModel extends AbstractModel {

	@Override
	public boolean isSafe() {
		return SocialDistancingUtil.isInterpolatedSafe(distance, duration, exhalationLevel);
	}

}
