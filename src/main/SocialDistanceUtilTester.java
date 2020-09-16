package main;

import data.Constants;
import util.SocialDistancingUtil;

public class SocialDistanceUtilTester {
	public static void main(String[] 
			args) {
		SocialDistancingUtil.printGivenAndGeneratedCombinationsDerivedSafety();
		SocialDistancingUtil.printGivenAndGeneratedCombinationsInferredSafety();
		SocialDistancingUtil.compareSafetyComputations();
		SocialDistancingUtil.printSafeDistancesAndDurations(Constants.MEDIUM_EXHALATION_LEVEL);
		SocialDistancingUtil.printSafeDistancesAndDurations(Constants.MEDIUM_EXHALATION_LEVEL-1);
		SocialDistancingUtil.printSafeDistancesAndDurations(Constants.MEDIUM_EXHALATION_LEVEL+2);
	}
}
