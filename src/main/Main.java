package main;

import java.util.Scanner;

import mainAccounting.MainAccountingProcedureInterface;
import manager.ManagerInterface;
import operator.OperatorInterface;
import provider.ProviderInterface;

/**
 * Main Class - Serves as menu to choose which interface to test from.
 */
public class Main {
	public static void main(String[] args) {

		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		boolean exitMainMenu = false;

		while (!exitMainMenu) {
			System.out.println("------------------------------------");
			System.out.println("1: Provider");
			System.out.println("2: Manager");
			System.out.println("3: Operator");
			System.out.println("4: Main Accounting Procedure");
			System.out.println("<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");
			System.out.println("5. Exit");
			System.out.println("------------------------------------");
			System.out.print("Please choose from the above options (1-5): ");
			int userChoice;
			try {
				userChoice = Integer.parseInt(myObj.nextLine()); // Read user input
			}
			catch (Exception e) {
				System.out.println("Invalid input!");
				return;
			}

			if (userChoice == 1) {
				new ProviderInterface();
			} else if (userChoice == 2) {
				new ManagerInterface();
			} else if (userChoice == 3) {
				new OperatorInterface();
			} else if (userChoice == 4) {
				new MainAccountingProcedureInterface();
			} else if (userChoice == 5) {
				exitMainMenu = true;
			} else {
				System.out.println("Invalid selection, please choose option between 1-5");
			}
		}

		myObj.close();

	}

}
