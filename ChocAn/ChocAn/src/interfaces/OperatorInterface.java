package interfaces;

import java.io.IOException;
import java.util.Scanner;

import controllers.OperatorController;
import entities.SystemUser;

public class OperatorInterface {
	private static OperatorController operatorController = new OperatorController();
    boolean exitMenu = false;

    /**
     * Constructor, prompts for a provider number then launches the main menu
     */
	public OperatorInterface() {
		operatorMainMenu();
	}

    public void operatorMainMenu() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        while(!exitMenu) {
	        System.out.println("---------------------");
	        System.out.println("1: Add Member");
	        System.out.println("2: Delete Member");
	        System.out.println("3: Update Member");
	        System.out.println("<<<<<<<<<<>>>>>>>>>>>>");
	        System.out.println("4: Add Provider");
	        System.out.println("5: Delete Provider");
	        System.out.println("6: Update Provider");
	        System.out.println("7: Exit");
	        System.out.println("---------------------");
			System.out.print("Please choose from the above options: ");
	        int userChoice = Integer.parseInt(myObj.nextLine()); // Read user input

			if(userChoice >= 1  && userChoice <= 7) {
				switch(userChoice) {
					case(1):
						addNewMember();
						break;
					case(2):
						break;
					case(3):
						break;
					case(4):
						addNewProvider();
						break;
					case(5):
						break;
					case(6):
						break;
					case(7):
						System.out.println("Exiting provider menu");
						exitMenu = true;
				}
			}
			else {
				System.out.println("Invalid selection, please choose option between 1-4" + userChoice);
			}
        }
    }

	private void addNewMember() {
		String memberName = promptForName();
		String memberStreetAddress = promptForStreetAddress();
		String memberCity = promptForCity();
		String memberState = promptForState();
		String memberZip = promptForZip();
		
		
		if(promptToConfirmUser(memberName, memberStreetAddress, memberCity, memberState, memberZip)) {
			operatorController.addNewMember(memberName, memberStreetAddress, memberCity, memberState, memberZip);
		}
		
	}

	private void addNewProvider() {
		String providerName = promptForName();
		String providerStreetAddress = promptForStreetAddress();
		String providerCity = promptForCity();
		String providerState = promptForState();
		String providerZip = promptForZip();
		
		
		if(promptToConfirmUser(providerName, providerStreetAddress, providerCity, providerState, providerZip)) {
			operatorController.addNewProvider(providerName, providerStreetAddress, providerCity, providerState, providerZip);
		}
		
	}

    public boolean verifyDeletion(SystemUser user) {
        return false;
    }

	private String promptForName() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please enter the user's name: ");
        String userName = myObj.nextLine(); // Read user input
        
        return userName;
	}

	private String promptForStreetAddress() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please enter the user's street address: ");
        String userStreetAddress = myObj.nextLine(); // Read user input
        
        return userStreetAddress;
	}

	private String promptForCity() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please enter the user's city: ");
        String userCity = myObj.nextLine(); // Read user input

        return userCity;
	}

	private String promptForState() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please enter the user's state: ");
        String userState = myObj.nextLine(); // Read user input
        
        return userState;
	}

	private String promptForZip() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please enter the user's zip code: ");
        String userZipCode = myObj.nextLine(); // Read user input
        
        return userZipCode;
	}

	private boolean promptToConfirmUser(String userName, String userStreetAddress, String userCity,
			String userState, String userZip) {
		System.out.println("Name: " + userName);
		System.out.println("Street Address: " + userStreetAddress);
		System.out.println("City: " + userCity);
		System.out.println("State: " + userState);
		System.out.println("Zip Code: " + userZip);
        Scanner myObj = new Scanner(System.in);
        while(true) {
    		System.out.print("Is the above information correct? (Yes or No): ");
	        String userChoice = myObj.nextLine();
	        if(userChoice.equals("Yes")) {
	        	return true;
	        }
	        else if(userChoice.equals("No")){
	        	return false;
	        }
	        else {
	        	System.out.println("Invalid input, please enter 'Yes' or 'No'");
	        }
        }
	}
}
