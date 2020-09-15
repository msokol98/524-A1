package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import factories.ModelFactory;

public class ConsoleSocialDistancingController implements SocialDistancingController {
	
	private Map<String, Integer> inputs = new HashMap<>();
	private String prompt = "Please enter data regarding your guest interaction.";

	public ConsoleSocialDistancingController() {
		inputs.put("Distance", null);
		inputs.put("Duration", null);
		inputs.put("Exhalation Level", null);
	}
	
	@Override
	public void processInput() {
		for(;;) {
			System.out.println(prompt);
			
			Scanner sn = new Scanner(System.in);
			
			for(String inputType : inputs.keySet()) {
				System.out.println(inputType + "?");
				int userInput = Integer.parseInt(sn.next());
								
				if(isValid(userInput)) 
					inputs.put(inputType, userInput);
				else
					System.out.println("Quitting.");
								
			}

			//sn.close();
			
			ModelFactory.getSocialDistancingModel().
				setInput(inputs.get("Distance"), 
						inputs.get("Duration"),
						inputs.get("Exhalation Level"));
		}
	}
	
	private boolean isValid(int input) {
		return input > 0;
	}
}
