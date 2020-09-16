package model;

import util.SocialDistancingUtil;

/**
 * This model is used when comparing a given input
 *  against Table 2 and seeing if the parameters
 *  are safer than at least one of the known safe combinations
 *  as outliend in Table 2
 */
public class DerivedModel extends AbstractModel {
	
	@Override
	public boolean isSafe() {
		return SocialDistancingUtil.isDerivedSafe(distance, duration, exhalationLevel);
	}

}
