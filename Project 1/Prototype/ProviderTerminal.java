
/**
 * prototype
 */
import java.util.Scanner; // Import the Scanner class

public class ProviderTerminal {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Please scan the member card or enter the member number:");
        String memberNumber = myObj.nextLine(); // Read user input

        Scanner myObj2 = new Scanner(System.in); // Create a Scanner object
        System.out.println("Begin Service or Bill for a Completed Service? (Enter 'BEGIN' or 'BILL'");
        String providerChoice = myObj2.nextLine(); // Read user input

        if (providerChoice.equals("BEGIN")) {
            VerifyMemberStatus status = new VerifyMemberStatus(memberNumber);
        } else if (providerChoice.equals("BILL")) {
            BillChocAnon bill = new BillChocAnon(memberNumber);
        } else {
            System.out.println("Invalid selection, exiting terminal");
        }
    }

}