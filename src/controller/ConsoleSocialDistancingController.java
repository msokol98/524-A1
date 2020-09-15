package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import factories.ModelFactory;

public class ConsoleSocialDistancingController implements SocialDistancingController {
	
	private final Map<String, Integer> inputs = new HashMap<>();
	private final String prompt = "Please enter data regarding your guest interaction.";
	
	public static final String DISTANCE = "Distance"; 
	public static final String DURATION = "Duration"; 
	public static final String EXHALATION_LEVEL = "Exhalation Level"; 

	private void addInputTypes() {
		inputs.put(DISTANCE, null);
		inputs.put(DURATION, null);
		inputs.put(EXHALATION_LEVEL, null);
	}
	
	@Override
	public void processInput() {
		final Scanner sn = new Scanner(System.in);
		addInputTypes();

		for(;;) {
			System.out.println(prompt);
			
			
			for(String inputType : inputs.keySet()) {
				System.out.println(inputType + "?");
				final int userInput = Integer.parseInt(sn.next());
								
				if(isValid(userInput)) {
					inputs.put(inputType, userInput);
										
				} else {
					System.out.println("Quitting.");
				}
								
			}
			
			ModelFactory.getSingleton().
				setInput
					(inputs.get(DISTANCE), 
					inputs.get(DURATION),
					inputs.get(EXHALATION_LEVEL));

		}
		//sn.close();
	}
	
	private boolean isValid(final int input) {
		return input > 0;
	}
}
