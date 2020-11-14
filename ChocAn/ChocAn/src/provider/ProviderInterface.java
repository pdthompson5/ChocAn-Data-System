package provider;

import java.util.ArrayList;
import java.util.Scanner;
import service.serviceOffered.providerDirectory.ProviderDirectory;
import service.serviceOffered.serviceOffered.ServiceOffered;

/**
 * Provider Interface - Interface for Providers to choose from several options
 * @author Griffin Mack
 * @author Topher Fryzel
 */
public class ProviderInterface {
	private String providerNumber;
	private ProviderDirectory providerDirectory = new ProviderDirectory();
	
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
			System.out.println("Invalid member number! Member does not exist. Returning to menu");
			return false;
		}
		
		boolean memberStatus = providerController.verifyMemberStatus(memberNumber);
		if(memberStatus && memberExists) {
			System.out.println("VALIDATED");
		}
		else {
			System.out.println("Member suspended! Returning to menu");
			return false;
		}
		return true;
    } 

    /**
     * Prints the provider directory
     *
     */
    public void printProviderDirectory() {
    	
    	//print provider directory to the terminal
    	//iterate through providerdirectory and print it out to the terminal.
    	
    	ArrayList<ServiceOffered> myProviderDirectory = new ArrayList<ServiceOffered>();
    	myProviderDirectory = providerDirectory.getProviderDirectory();
    	
    	for(int i = 0; i<myProviderDirectory.size(); ++i) {
    		System.out.print("Service Code: ");
    		System.out.print((myProviderDirectory.get(i)).getServiceCode());
    		System.out.print("	Service Name: ");
    		System.out.print((myProviderDirectory.get(i)).getServiceName());
    		System.out.print("	Service Fee: ");
    		System.out.print((myProviderDirectory.get(i)).getServiceFee());
    		System.out.println("");
    		
    	}
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

		String serviceTime = promptForServiceTime();
		
		String serviceCode = promptForServiceCode();
		if(!verifyServiceCode(serviceCode)) return;
		
		String serviceComments = promptForServiceComments();
		
		providerController.billChocan(this.providerNumber, memberNumber, serviceDate, serviceCode, serviceComments, serviceTime);
    }

    /**
     * Prompts user for a member number
     * @return String memberNumber
     */
	private String promptForMemberNumber() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.print("Please scan the member card or enter the member number: ");
        String memberNumber = myObj.nextLine(); // Read user input
        
        //  Error check the entered member number (formatting)
        // what should be returned when this fails?
        if(memberNumber.length()>9) {
        	System.out.println("Member number too long!");
        	promptForMemberNumber();
        }
        if(memberNumber.length()<9) {
        	System.out.println("Member number too short!");
        	promptForMemberNumber();
        }
        for(int i = 0; i<memberNumber.length(); ++i) {
        	if(!(Character.isDigit(memberNumber.charAt(i)))) {
        		System.out.println("Used non-digit characters!");
        		promptForMemberNumber();
        	}
        }
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
        
        //  Error check the entered provider number (formatting)
        if(providerNumber.length()>9) {
        	System.out.println("Provider number too long!");
        	promptForProviderNumber();
        }
        if(providerNumber.length()<9) {
        	System.out.println("Provider number too short!");
        	promptForProviderNumber();
        }
        for(int i = 0; i<providerNumber.length(); ++i) {
        	if(!(Character.isDigit(providerNumber.charAt(i)))) {
        		System.out.println("Used non-digit characters!");
        		promptForProviderNumber();
        	}
        }
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

        // Error check the entered service date (formatting)
        if(serviceDate.length()>9) {
        	System.out.println("Service date too long!");
        	promptForServiceDate();
        }
        if(serviceDate.length()<9) {
        	System.out.println("Service date too short!");
        	promptForServiceDate();
        }
        
        if(!(Character.isDigit(serviceDate.charAt(0)))) {
    		System.out.println("Used non-digit characters!");
    		promptForServiceDate();
    	}
    	if(!(Character.isDigit(serviceDate.charAt(1)))) {
    		System.out.println("Used non-digit characters!");
    		promptForServiceDate();
    	}
    	if(serviceDate.charAt(2)!='-') {
    		System.out.println("Please use a dash.");
    		promptForServiceDate();
    	}
    	if(!(Character.isDigit(serviceDate.charAt(3)))) {
    		System.out.println("Used non-digit characters!");
    		promptForServiceDate();
    	}
    	if(!(Character.isDigit(serviceDate.charAt(4)))) {
    		System.out.println("Used non-digit characters!");
    		promptForServiceDate();
    	}
    	if(serviceDate.charAt(5)!='-') {
    		System.out.println("Please use a dash.");
    		promptForServiceDate();
    	}
        for(int i = 6; i<10; ++i) {
        	if(!(Character.isDigit(serviceDate.charAt(i)))) {
        		System.out.println("Used non-digit characters!");
        		promptForServiceDate();
        	}
        }
        
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
        
        // Error check the entered service code (formatting)
        if(serviceCode.length()>6) {
        	System.out.println("Service code too long!");
        	promptForServiceCode();
        }
        if(serviceCode.length()<6) {
        	System.out.println("Service code too short!");
        	promptForServiceCode();
        }
        for(int i = 0; i<serviceCode.length(); ++i) {
        	if(!(Character.isDigit(serviceCode.charAt(i)))) {
        		System.out.println("Used non-digit characters!");
        		promptForServiceCode();
        	}
        }
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
        
        // Cuts the comments off at 100 characters
        if(serviceComments.length()>100) {
        	serviceComments.equals(serviceComments.substring(0,99));
        }
        return serviceComments;
	}

	/**
	 * Prompts for a time service was served
	 * @return String serviceTime
	 */
	private String promptForServiceTime() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter service time: ");
		String serviceTime = scanner.next();
		return serviceTime;
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
