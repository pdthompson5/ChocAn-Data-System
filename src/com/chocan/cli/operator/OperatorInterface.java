package com.chocan.cli.operator;

import java.util.Scanner;

import com.chocan.user.operator.OperatorController;

public class OperatorInterface {
	private static OperatorController operatorController = new OperatorController();
	private String operatorNumber;

	public void operatorMainMenu() {
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		boolean exit = false;
        while(exit == false) {
	        System.out.print("Please enter your operator number: ");
	        operatorNumber = myObj.nextLine(); // Read user input
	        
	        // TODO Error check the provider number
	        exit = operatorSelectionMenu();
        }
	}

	private boolean operatorSelectionMenu() {
        boolean exitMenu = false;
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        while(!exitMenu) {
			System.out.println("------------------------------------");
			System.out.println("1. Manage Member Records");
			System.out.println("2. Manage Provider Records");
			System.out.println("3. Add a Member");
			System.out.println("4. Add a Provider");
			System.out.println("5. Exit");
			System.out.println("------------------------------------");
			System.out.print("Please choose from the above options(1-5): ");
	        int userChoice = Integer.parseInt(myObj.nextLine()); // Read user input
			
			if(userChoice >= 1  && userChoice <= 4) {
				switch(userChoice) {
					case(1):
						manageExistingMemberRecords();
						break;
					case(2):
						manageExistingProviderRecords();
						break;
					case(3):
						addNewMember();
						break;
					case(4):
						addNewProvider();
						break;
				}
			}
			else if(userChoice == 5) {
				System.out.println("Exiting");
				exitMenu = true;
			}
			else {
				System.out.println("Invalid selection, please choose option between 1-5" + userChoice);
			}
		}
		return exitMenu;
	}

	private void manageExistingProviderRecords() {
		// TODO Auto-generated method stub
		
	}

	private void manageExistingMemberRecords() {
		// TODO Auto-generated method stub
		
	}

	private void addNewProvider() {
		String providerName = promptForName();
		String providerStreetAddress = promptForStreetAddress();
		String providerCity = promptForCity();
		String providerState = promptForState();
		String providerZip = promptForZip();
		
		
		if(promptToConfirm(providerName, providerStreetAddress, providerCity, providerState, providerZip)) {
			operatorController.addNewProvider(providerName, providerStreetAddress, providerCity, providerState, providerZip);
		}
		
	}

	private void addNewMember() {
		String memberName = promptForName();
		String memberStreetAddress = promptForStreetAddress();
		String memberCity = promptForCity();
		String memberState = promptForState();
		String memberZip = promptForZip();
		
		
		if(promptToConfirm(memberName, memberStreetAddress, memberCity, memberState, memberZip)) {
			operatorController.addNewMember(memberName, memberStreetAddress, memberCity, memberState, memberZip);
		}
		
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

	private boolean promptToConfirm(String userName, String userStreetAddress, String userCity,
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
