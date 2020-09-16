package controller;

import java.util.Scanner;

import factory.ModelFactory;

public class ConsoleSocialDistancingController implements SocialDistancingController {
	
	private final String prompt = "Please enter data regarding your guest interaction.";
	private Scanner sn;

	private int inputNum(final String attr) {
		System.out.println(attr + "?");
		return (int) sn.nextDouble();
	}
	
	@Override
	public void processInput() {
		sn = new Scanner(System.in);
		
		for(;;) {
			
			System.out.println(prompt);
			
			final int distance = inputNum("Distance");
			if(!isValid(distance)) {
				break;
			}
			
			final int duration = inputNum("Duration");
			if(!isValid(duration)) {
				break;
			}
			
			final int exhalationLevel = inputNum("Exhalation Level");
			if(!isValid(exhalationLevel)) {
				break;
			}
			
			ModelFactory.getSingleton()
				.setInput(distance, duration, exhalationLevel);

		}
		
		System.out.println("Quitting.");
	}
	
	private boolean isValid(final int input) {
		return input > 0;
	}
}
