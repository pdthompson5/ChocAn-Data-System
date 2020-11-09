package com.chocan.cli.provider;

import com.chocan.user.provider.ProviderDataController;
import java.util.Scanner; 

public class ProviderInterface {
	private static ProviderDataController providerController = new ProviderDataController();
	private String providerNumber;

	public void providerMainMenu() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        while(true) {
	        System.out.print("Please enter your provider number: ");
	        providerNumber = myObj.nextLine(); // Read user input
	        
	        // TODO Error check the provider number
	        providerSelectionMenu();
        }
	}

	private void providerSelectionMenu() {
        boolean exitMenu = false;
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        while(!exitMenu) {
			System.out.println("------------------------------------");
			System.out.println("1. Verify Member Status");
			System.out.println("2. Bill for a ChocAn Service");
			System.out.println("3. Request the Provider Directory");
			System.out.println("4. Exit");
			System.out.println("------------------------------------");
			System.out.print("Please choose from the above options: ");
	        int userChoice = Integer.parseInt(myObj.nextLine()); // Read user input
			
			if(userChoice >= 1  && userChoice <= 3) {
				switch(userChoice) {
					case(1):
						verifyMember(promptForMemberNumber());
						break;
					case(2):
						billChocan(promptForMemberNumber());
						break;
					case(3):
						requestProviderDirectory();
						break;
				}
			}
			else if(userChoice == 4) {
				System.out.println("Exiting");
				exitMenu = true;
			}
			else {
				System.out.println("Invalid selection, please choose option between 1-3" + userChoice);
			}
        }
	}

	private void billChocan(String memberNumber) {		
		if(!verifyMember(memberNumber)) {
			return;
		}
		String serviceDate = promptForServiceDate();
		
		String serviceCode = promptForServiceCode();
		if(!validateServiceCode(serviceCode)) return;
		
		String serviceComments = promptForServiceComments();
		
		providerController.billChocan(providerNumber, memberNumber, serviceDate, serviceCode, serviceComments);
		
	}
	private String requestProviderDirectory() {
		String providerDirectory = providerController.getProviderDirectory();

		return providerDirectory;
	}

	private boolean verifyMember(String memberNumber) {	
		boolean memberExists = providerController.verifyMemberExists(memberNumber);
		if(!memberExists) {
			System.out.println("Invalid member number! returning to menu");
			return false;
		}
		
		boolean memberStatus = providerController.verifyMemberStatus(memberNumber);
		if(memberStatus && memberExists) {
			System.out.println("VALIDATED");
		}
		else {
			System.out.println("Member suspended! returning to menu");
			return false;
		}
		return true;
	}
	
	private String promptForMemberNumber() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please scan the member card or enter the member number: ");
        String memberNumber = myObj.nextLine(); // Read user input

        return memberNumber;
	}
	
	private String promptForServiceDate() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please enter the service date (format: MM-DD-YYYY): ");
        String serviceDate = myObj.nextLine(); // Read user input

        //TODO Error check the entered service date

        return serviceDate;
	}
	
	private String promptForServiceCode() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please enter the six-digit service code: ");
        String serviceCode = myObj.nextLine(); // Read user input
        

        return serviceCode;
	}

	private boolean validateServiceCode(String serviceCode) {
		// TODO Check that the service code is the correct amount of digits
		
		String serviceName = providerController.lookupServiceByCode(serviceCode);
		if(serviceName != null) {
	        Scanner myObj = new Scanner(System.in);
	        while(true) {
				System.out.println(serviceName + " - Is this service correct? (Yes or No): ");
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
		else {
			System.out.println("Invalid service code");
			return false;
		}
	}
	
	private String promptForServiceComments() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Please enter any additional service comments: ");
        String serviceComments = myObj.nextLine(); // Read user input
        
        // TODO cut the comments off at 100 characters
        return serviceComments;
	}
}
