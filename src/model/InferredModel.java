package model;

import util.SocialDistancingUtil;

public class InferredModel extends AbstractModel {
	

	@Override
	public boolean isSafe() {
		return SocialDistancingUtil.isInferredSafe(distance, duration, exhalationLevel);
	}

}
