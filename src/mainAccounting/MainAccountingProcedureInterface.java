package mainAccounting;

import java.util.Scanner;
import mainAccounting.MainAccountingProcedureController;

/**
 * Main Accounting Procedure Interface - Interface for testing the main
 * accounting procedure
 * 
 * @author Griffin Mack
 */
public class MainAccountingProcedureInterface {
    private boolean exitMenu = false;

    private MainAccountingProcedureController mapController = new MainAccountingProcedureController();

    /**
     * Constructor, prompts for a provider number then launches the main menu
     */
    public MainAccountingProcedureInterface() {
        MainAccountingProcedureMainMenu();
    }

    public void MainAccountingProcedureMainMenu() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        while (!exitMenu) {
            System.out.println("-------------------------------------");
            System.out.println("1. Run Main Accounting Procedure");
            System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");
            System.out.println("2. Exit");
            System.out.println("-------------------------------------");
            System.out.print("Please choose from the above options: ");
            int userChoice = Integer.parseInt(myObj.nextLine()); // Read user input

            if (userChoice >= 1 && userChoice <= 2) {
                switch (userChoice) {
                    case (1):
                        runMainAccountingProcedure();
                        break;
                    case (2):
                        System.out.println("Exiting main accounting procedure menu");
                        exitMenu = true;
                }
            } else {
                System.out.println("Invalid selection, please choose option between 1-2");
            }
        }
    }

    private void runMainAccountingProcedure() {
        mapController.runMainAccountingProcedure();
    }
}
