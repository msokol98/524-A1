package model;

import util.SocialDistancingUtil;

/**
 * This model is used when Weka is being used to infer
 * whether social distancing parameters are safe or not.
 */
public class InferredModel extends AbstractModel {
	

	@Override
	public boolean isSafe() {
		return SocialDistancingUtil.isInferredSafe(distance, duration, exhalationLevel);
	}

}
