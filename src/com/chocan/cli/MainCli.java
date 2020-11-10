package com.chocan.cli;

import java.util.Scanner;

import com.chocan.cli.accounting.MainAccountingProcedureInterface;
import com.chocan.cli.manager.ManagerInterface;
import com.chocan.cli.operator.OperatorInterface;
import com.chocan.cli.provider.*;

public class MainCli {

	public static void main(String[] args) {
		ProviderInterface provider = new ProviderInterface();
		ManagerInterface manager = new ManagerInterface();
		OperatorInterface operator = new OperatorInterface();
		MainAccountingProcedureInterface mainAccounting = new MainAccountingProcedureInterface();
		
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
		while(true) {
			System.out.println("------------------------------------");
			System.out.println("1. Provider Terminal");
			System.out.println("2. Manager Terminal");
			System.out.println("3. Operator Terminal");
			System.out.println("4. Main Accounting Procedure (Testing only)");
			System.out.println("5. Exit");
			System.out.println("------------------------------------");
			System.out.print("Please choose from the above options (1-5): ");
	        int userChoice = Integer.parseInt(myObj.nextLine()); // Read user input
			
			if(userChoice >= 1  && userChoice <= 4) {
				switch(userChoice) {
					case(1):
						provider.providerMainMenu();
						break;
					case(2):
						manager.managerMainMenu();
						break;
					case(3):
						operator.operatorMainMenu();
						break;
					case(4):
						mainAccounting.runMainAccountingProcedure();
						break;
					case(5):
						// TODO: Make this terminate the process
				}
			}
			else {
				System.out.println("Invalid selection, please choose option between 1-3" + userChoice);
			}
        }			
	}
}
