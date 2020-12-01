package provider;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

import service.serviceOffered.providerDirectory.ProviderDirectory;
import service.serviceOffered.serviceOffered.ServiceOffered;

/**
 * Provider Interface - Interface for Providers to choose from several options
 * 
 * @author Griffin Mack
 * @author Topher Fryzel
 * @author Ben Peinhardt
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
		this.providerNumber = promptForProviderNumber();
		providerMainMenu();
	}

	/**
	 * Main menu for provider options
	 */
	private void providerMainMenu() {
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		while (!exitMenu) {
			System.out.println("------------------------------------");
			System.out.println("1. Verify Member Status");
			System.out.println("2. Bill for a ChocAn Service");
			System.out.println("3. Request the Provider Directory");
			System.out.println("4. Exit");
			System.out.println("------------------------------------");
			System.out.print("Please choose from the above options: ");
			int userChoice = Integer.parseInt(myObj.nextLine()); // Read user input

			if (userChoice >= 1 && userChoice <= 4) {
				switch (userChoice) {
					case (1):
						verifyMember(promptForMemberNumber());
						break;
					case (2):
						billChocAn(promptForMemberNumber());
						break;
					case (3):
						printProviderDirectory();
						break;
					case (4):
						System.out.println("Exiting provider menu");
						exitMenu = true;
				}
			} else {
				System.out.println("Invalid selection, please choose option between 1-4" + userChoice);
			}
		}
	}

	/**
	 * Verifies a member number exists and is valid
	 * 
	 * @param String memberNumber
	 * @return boolean
	 */
	public boolean verifyMember(String memberNumber) {
		boolean memberExists = providerController.verifyMemberExists(memberNumber);
		if (!memberExists) {
			System.out.println("Invalid member number! Member does not exist. Returning to menu");
			return false;
		}

		boolean memberStatus = providerController.verifyMemberStatus(memberNumber);
		if (memberStatus && memberExists) {
			System.out.println("VALIDATED");
		} else {
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

		// print provider directory to the terminal
		// iterate through providerdirectory and print it out to the terminal.

		ArrayList<ServiceOffered> myProviderDirectory = new ArrayList<ServiceOffered>();
		myProviderDirectory = providerDirectory.getProviderDirectory();

		for (int i = 0; i < myProviderDirectory.size(); ++i) {
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
	 * 
	 * @param String memberNumber
	 */
	public void billChocAn(String memberNumber) {
		if (!verifyMember(memberNumber)) {
			return;
		}
		String serviceDate = promptForServiceDate();

		String currTime = generateDateTime();

		String serviceCode = promptForServiceCode();
		if (!verifyServiceCode(serviceCode))
			return;

		String serviceComments = promptForServiceComments();

		providerController.billChocan(this.providerNumber, memberNumber, serviceDate, serviceCode, serviceComments,
				currTime);

		System.out.print("Your service fee is: $");
		System.out.println(getServicePrice(serviceCode));
	}

	/**
	 * Prompts user for a member number
	 * 
	 * @return String memberNumber
	 */
	private String promptForMemberNumber() {
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.print("Please scan the member card or enter the member number: ");
		String memberNumber = myObj.nextLine(); // Read user input

		// Error check the entered member number (formatting)
		// what should be returned when this fails?
		if (memberNumber.length() > 9) {
			System.out.println("Member number too long!");
			return promptForMemberNumber();
		}
		if (memberNumber.length() < 9) {
			System.out.println("Member number too short!");
			return promptForMemberNumber();
		}
		for (int i = 0; i < memberNumber.length(); ++i) {
			if (!(Character.isDigit(memberNumber.charAt(i)))) {
				System.out.println("Used non-digit characters!");
				return promptForMemberNumber();
			}
		}
		return memberNumber;
	}

	/**
	 * Prompts user for a provider number
	 * 
	 * @return String providerNumber
	 */
	private String promptForProviderNumber() {
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.print("Please enter your Provider Number: ");
		String providerNumber = myObj.nextLine(); // Read user input

		// Error check the entered provider number (formatting)
		if (providerNumber.length() > 9) {
			System.out.println("Provider number too long!");
			promptForProviderNumber();
		}
		if (providerNumber.length() < 9) {
			System.out.println("Provider number too short!");
			promptForProviderNumber();
		}
		for (int i = 0; i < providerNumber.length(); ++i) {
			if (!(Character.isDigit(providerNumber.charAt(i)))) {
				System.out.println("Used non-digit characters!");
				promptForProviderNumber();
			}
		}
		return providerNumber;
	}

	/**
	 * Prompts user for a service date
	 * 
	 * @return String serviceDate
	 */
	private String promptForServiceDate() {
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.print("Please enter the service date (format: MM-DD-YYYY): ");
		String serviceDate = myObj.nextLine(); // Read user input

		// Error check the entered service date (formatting)
		boolean isValid = true;
		if (serviceDate.length() > 10 && isValid) {
			System.out.println("Service date too long!");
			isValid = false;
		}
		if (serviceDate.length() < 10 && isValid) {
			System.out.println("Service date too short!");
			isValid = false;
		}
		if (!(Character.isDigit(serviceDate.charAt(0))) && isValid) {
			System.out.println("Used non-digit characters!");
			isValid = false;
		}
		if (!(Character.isDigit(serviceDate.charAt(1))) && isValid) {
			System.out.println("Used non-digit characters!");
			isValid = false;
		}
		if (serviceDate.charAt(2) != '-' && isValid) {
			System.out.println("Please use a dash.");
			isValid = false;
		}
		if (!(Character.isDigit(serviceDate.charAt(3))) && isValid) {
			System.out.println("Used non-digit characters!");
			isValid = false;
		}
		if (!(Character.isDigit(serviceDate.charAt(4))) && isValid) {
			System.out.println("Used non-digit characters!");
			isValid = false;
		}
		if (serviceDate.charAt(5) != '-' && isValid) {
			System.out.println("Please use a dash.");
			isValid = false;
		}
		for (int i = 6; i < 10 && isValid; ++i) {
			if (!(Character.isDigit(serviceDate.charAt(i))) && isValid) {
				System.out.println("Used non-digit characters!");
				isValid = false;
			}
		}
		if (!isValid) {
			promptForServiceDate();
		}
		return serviceDate;
	}

	/**
	 * Prompts user for a service code
	 * 
	 * @return String serviceCode
	 */
	private String promptForServiceCode() {
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.print("Please enter the six-digit service code: ");
		String serviceCode = myObj.nextLine(); // Read user input

		// Error check the entered service code (formatting)
		if (serviceCode.length() > 6) {
			System.out.println("Service code too long!");
			promptForServiceCode();
		}
		if (serviceCode.length() < 6) {
			System.out.println("Service code too short!");
			promptForServiceCode();
		}
		for (int i = 0; i < serviceCode.length(); ++i) {
			if (!(Character.isDigit(serviceCode.charAt(i)))) {
				System.out.println("Used non-digit characters!");
				promptForServiceCode();
			}
		}
		return serviceCode;
	}

	/**
	 * Prompts user for additional comments
	 * 
	 * @return String serviceComments
	 */
	private String promptForServiceComments() {
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("Please enter any additional service comments: ");
		String serviceComments = myObj.nextLine(); // Read user input

		// No commas
		if (serviceComments.contains(",")) {
			System.out.println("Comments cannot contain a comma");
			return promptForServiceComments();
		}

		// Cuts the comments off at 100 characters
		if (serviceComments.length() > 100) {
			serviceComments.equals(serviceComments.substring(0, 99));
		}
		return serviceComments;
	}

	/**
	 * Uses the Date object to generate a string with the current date and time
	 * 
	 * @return String serviceTime
	 */
	private String generateDateTime() {
		Date todaysDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		return formatter.format(todaysDate);
	}

	/**
	 * Verifies a service code
	 * 
	 * @return boolean
	 */
	private boolean verifyServiceCode(String serviceCode) {
		String serviceName = providerController.lookupServiceByCode(serviceCode);
		if (serviceName != null) {
			Scanner myObj = new Scanner(System.in);
			while (true) {
				System.out.print(serviceName + " - Is this service correct? (Yes or No): ");
				String userChoice = myObj.nextLine();
				if (userChoice.equals("Yes")) {
					return true;
				} else if (userChoice.equals("No")) {
					return false;
				} else {
					System.out.println("Invalid input, please enter 'Yes' or 'No'");
				}
			}
		} else {
			System.out.println("Invalid service code");
			return false;
		}
	}

	/**
	 * Gets the service price for a particular service for printing
	 * 
	 * @param serviceCode
	 * @return double fee
	 */
	private double getServicePrice(String serviceCode) {
		double price = providerController.lookupServicePriceByCode(serviceCode);
		return price;
	}
}
