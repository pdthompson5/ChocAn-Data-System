package provider;

import java.util.Scanner;

/**
 * Provider Interface - Interface for Providers to choose from several options
 * @author Griffin Mack
 */
public class ProviderInterface {
	private String providerNumber;
	private static ProviderController providerController = new ProviderController();
    boolean exitMenu = false;

    /**
     * Constructor, prompts for a provider number then launches the main menu
     */
	public ProviderInterface() {
		providerNumber = promptForProviderNumber();
		providerMainMenu();
	}

    /**
     * Main menu for provider options
     */
	private void providerMainMenu() {
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
			
			if(userChoice >= 1  && userChoice <= 4) {
				switch(userChoice) {
					case(1):
						verifyMember(promptForMemberNumber());
						break;
					case(2):
						billChocAn(promptForMemberNumber());
						break;
					case(3):
						printProviderDirectory();
						break;
					case(4):
						System.out.println("Exiting provider menu");
						exitMenu = true;
				}
			}
			else {
				System.out.println("Invalid selection, please choose option between 1-4" + userChoice);
			}
        }
	}

    /**
     * Verifies a member number exists and is valid
     * @param String memberNumber
     * @return boolean
     */
    public boolean verifyMember(String memberNumber) {
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

    /**
     * Prints the provider directory
     */
    public void printProviderDirectory() {
    	// TODO grab and print the provider directory
    }

    /**
     * Bills ChocAn for a service provided
     * @param String memberNumber
     */
    public void billChocAn(String memberNumber) {
		if(!verifyMember(memberNumber)) {
			return;
		}
		String serviceDate = promptForServiceDate();
		
		String serviceCode = promptForServiceCode();
		if(!verifyServiceCode(serviceCode)) return;
		
		String serviceComments = promptForServiceComments();
		
		providerController.billChocan(this.providerNumber, memberNumber, serviceDate, serviceCode, serviceComments);
    }

    /**
     * Prompts user for a member number
     * @return String memberNumber
     */
	private String promptForMemberNumber() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please scan the member card or enter the member number: ");
        String memberNumber = myObj.nextLine(); // Read user input
        
        // TODO Error check the entered member number (formatting)

        return memberNumber;
	}

    /**
     * Prompts user for a provider number
     * @return String providerNumber
     */
	private String promptForProviderNumber() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please enter your Provider Number: ");
        String providerNumber = myObj.nextLine(); // Read user input
        
        // TODO Error check the entered provider number (formatting)

        return providerNumber;
	}

    /**
     * Prompts user for a service date
     * @return String serviceDate
     */
	private String promptForServiceDate() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please enter the service date (format: MM-DD-YYYY): ");
        String serviceDate = myObj.nextLine(); // Read user input

        //TODO Error check the entered service date (formatting)

        return serviceDate;
	}

    /**
     * Prompts user for a service code
     * @return String serviceCode
     */
	private String promptForServiceCode() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please enter the six-digit service code: ");
        String serviceCode = myObj.nextLine(); // Read user input
        
        //TODO Error check the entered service code (formatting)

        return serviceCode;
	}

    /**
     * Prompts user for additional comments
     * @return String serviceComments
     */
	private String promptForServiceComments() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Please enter any additional service comments: ");
        String serviceComments = myObj.nextLine(); // Read user input
        
        // TODO cut the comments off at 100 characters
        return serviceComments;
	}

    /**
     * Verifies a service code
     * @return boolean 
     */
	private boolean verifyServiceCode(String serviceCode) {		
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
}
