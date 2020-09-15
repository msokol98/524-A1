package main;

import controller.ConsoleSocialDistancingController;
import factories.ClassifierFactory;
import factories.ControllerFactory;
import factories.ModelFactory;
import factories.ViewFactory;
import gradingTools.comp524f20.assignment1.F20Assignment1Suite;
import gradingTools.comp524f20.assignment1.SocialDistanceClassRegistry;
import model.BasicModel;
import model.DerivedModel;
import model.InterpolatingModel;
import util.SocialDistanceUtilTester;
import util.SocialDistancingUtil;
import view.SocialDistancingViewImpl;

public class TestPlayground implements SocialDistanceClassRegistry {
	
	public static void main(final String[] args) {
		F20Assignment1Suite.main(args);
	}

	@Override
	public Class<?> getBasicSocialDistanceUtility() {
		// TODO Auto-generated method stub
		return SocialDistancingUtil.class;
	}

	@Override
	public Class<?> getSocialDistancDerivingModel() {
		// TODO Auto-generated method stub
		return DerivedModel.class;
	}

	@Override
	public Class<?> getSocialDistancInferringModel() {
		// TODO Auto-generated method stub
		return InterpolatingModel.class;
	}

	@Override
	public Class<?> getSocialDistanceBasicModel() {
		// TODO Auto-generated method stub
		return BasicModel.class;
	}

	@Override
	public Class<?> getSocialDistanceClassifierFactory() {
		// TODO Auto-generated method stub
		return ClassifierFactory.class;
	}

	@Override
	public Class<?> getSocialDistanceController() {
		// TODO Auto-generated method stub
		return ConsoleSocialDistancingController.class;
	}

	@Override
	public Class<?> getSocialDistanceControllerFactory() {
		// TODO Auto-generated method stub
		return ControllerFactory.class;
	}

	@Override
	public Class<?> getSocialDistanceInterpolatingModel() {
		// TODO Auto-generated method stub
		return InterpolatingModel.class;
	}

	@Override
	public Class<?> getSocialDistanceMVCBasicMain() {
		// TODO Auto-generated method stub
		return BasicMain.class;
	}

	@Override
	public Class<?> getSocialDistanceMVCDerivingMain() {
		// TODO Auto-generated method stub
		return DerivingMain.class;
	}

	@Override
	public Class<?> getSocialDistanceMVCInferringMain() {
		// TODO Auto-generated method stub
		return InferringMain.class;
	}

	@Override
	public Class<?> getSocialDistanceMVCInterpolatingMain() {
		// TODO Auto-generated method stub
		return InterpolatingMain.class;
	}

	@Override
	public Class<?> getSocialDistanceModelFactory() {
		// TODO Auto-generated method stub
		return ModelFactory.class;
	}

	@Override
	public Class<?> getSocialDistanceUilityTesterMain() {
		// TODO Auto-generated method stub
		return SocialDistanceUtilTester.class;
	}

	@Override
	public Class<?> getSocialDistanceView() {
		// TODO Auto-generated method stub
		return SocialDistancingViewImpl.class;
	}

	@Override
	public Class<?> getSocialDistanceViewFactory() {
		// TODO Auto-generated method stub
		return ViewFactory.class;
	}
	
}
