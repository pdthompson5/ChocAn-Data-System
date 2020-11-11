package interfaces;

import java.util.Scanner;

/**
 * Main Class - Serves as menu to choose which interface to test from. 
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println("1: Provider");
        System.out.println("2: Manager");
        System.out.println("3: Operator");
        System.out.println("4: Main Accounting Procedure");
        System.out.println("5: Quit");
        System.out.println("----------------------------------");

        // Get users choice
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        if (choice == "1") {
            ProviderInterface pi = new ProviderInterface();
        } else if (choice == "2") {
            ManagerInterface mi = new ManagerInterface();
        } else if (choice == "3") {
            OperatorInterface oi = new OperatorInterface();
            oi.promptForOperation();
        } else if (choice == "4") {
            MainAccountingProcedure mac = new MainAccountingProcedure();
        }


    }

    
}

