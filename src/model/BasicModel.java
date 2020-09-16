package model;

import util.SocialDistancingUtil;

/**
 * Basic model for determing whether input parameters
 * are safe in terms of socially distancing according to Table 2
 */
public class BasicModel extends AbstractModel {

	@Override
	public boolean isSafe() {
		return SocialDistancingUtil.isGivenSafe(distance, duration, exhalationLevel);
	}
	
}
