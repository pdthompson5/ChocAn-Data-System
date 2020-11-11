package interfaces;

import java.util.Scanner;

import entities.SystemUser;

public class OperatorInterface {
    public void manageProviderRecords() {

    }

    public void manageMemberRecords() {

    } 

    public void promptForOperation() {
        System.out.println("---------------------");
        System.out.println("1: Add Member");
        System.out.println("2: Delete Member");
        System.out.println("3: Update Member");
        System.out.println("---------------------");
        System.out.println("4: Add Provider");
        System.out.println("5: Delete Provider");
        System.out.println("6: Update Provider");
        System.out.println("---------------------");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        
        if (choice == "1") {
            
        }
    }

    public boolean verifyDeletion(SystemUser user) {
        return false;
    }

    public String promptForName() {
        return "name";
    }

    public String promptForStreetAddress() {
        return "address";
    }

    public String promptForCity() {
        return "city";
    }

    public String promptForSate() {
        return "AL";
    }

    public String promptForZIP() {
        return "00000";
    }

    public boolean tryAgainPrompt() {
        return false;
    }

    public boolean confirmUser(SystemUser user) {
        return false;
    }

    public String promptForNewData() {
        return "new_data";
    }

    public boolean promptForAnotherChange() {
        return false;
    }
}
