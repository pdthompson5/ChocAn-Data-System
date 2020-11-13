package operator;

import java.io.IOException;
import java.util.Scanner;

import entities.*;
import systemUser.SystemUser;

/**
 * Operator Interface - Interface for Operators to manage member and provider data
 * @author Griffin Mack
 * @author Ben Peinhardt
 */
public class OperatorInterface {
	private OperatorController operatorController = new OperatorController();
    boolean exitMenu = false;

    /**
     * Constructor, launches the operator main menu
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
						deleteMember();
						break;
					case(3):
						updateMember();
						break;
					case(4):
						addNewProvider();
						break;
					case(5):
						deleteProvider();
						break;
					case(6):
						updateProvider();
						break;
					case(7):
						System.out.println("Exiting operator menu");
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

	private void deleteMember() {
		String memberNumber = promptForMemberNumber();
		operatorController.deleteMember(memberNumber);
		
	}

	private void updateMember() {
		// TODO Auto-generated method stub
		
	}

	private void addNewProvider() {
		String providerName = promptForName();
		String providerStreetAddress = promptForStreetAddress();
		String providerCity = promptForCity();
		String providerState = promptForState();
		String providerZip = promptForZip();
		
		
		if(promptToConfirmUser(providerName, providerStreetAddress, providerCity, providerState, providerZip)) {
			this.operatorController.addNewProvider(providerName, providerStreetAddress, providerCity, providerState, providerZip);
		}	
	}

	private void deleteProvider() {
		String providerNumber = promptForProviderNumber();
		operatorController.deleteProvider(providerNumber);
	}

	private void updateProvider() {
		// TODO Auto-generated method stub
		
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

    /**
     * Prompts user for a member number (Functionality shared with ProviderInterface)
     * @return String memberNumber
     */
	private String promptForMemberNumber() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please enter the member number: ");
        String memberNumber = myObj.nextLine(); // Read user input
        
        // TODO Error check the entered member number (formatting)

        return memberNumber;
	}

    /**
     * Prompts user for a provider number (Functionality shared with ProviderInterface)
     * @return String providerNumber
     */
	private String promptForProviderNumber() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please enter the Provider Number: ");
        String providerNumber = myObj.nextLine(); // Read user input
        
        // TODO Error check the entered provider number (formatting)

        return providerNumber;
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
