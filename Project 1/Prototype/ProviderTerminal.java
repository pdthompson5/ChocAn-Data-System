
/**
 * prototype
 */
import java.util.Scanner; // Import the Scanner class
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProviderTerminal {

    // public static String createServiceRecord(String memberNumber, String dateOfService, String serviceCode,
    //         String serviceComments) {
    //     // grab the current date and time
    //     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    //     Date date = new Date();
    //     String currentDate = formatter.format(date);

    //     // Create a record and save it to a file
    //     String serviceRecord = "Current date and time: " + currentDate + "\n";
    //     serviceRecord += "Date service was provided: " + dateOfService + "\n";
    //     serviceRecord += "Provider number: " + "notImplemented.." + "\n";
    //     serviceRecord += "Member number: " + memberNumber + "\n";
    //     serviceRecord += "Service code: " + serviceCode + "\n";
    //     serviceRecord += "Comments: " + serviceComments + "\n";

    //     return serviceRecord;

    // }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Please scan the member card or enter the member number:");
        String memberNumber = myObj.nextLine(); // Read user input
    
        Scanner myObj2 = new Scanner(System.in); // Create a Scanner object
        System.out.println("Begin Service or Bill for a Completed Service? (Enter 'BEGIN' or 'BILL'");
        String providerChoice = myObj2.nextLine(); // Read user input

        if(providerChoice.equals("BEGIN")){
            VerifyMemberStatus status = new VerifyMemberStatus(memberNumber);
        }
        else if(providerChoice.equals("BILL")){
            BillChocAnon bill = new BillChocAnon(memberNumber);
        }
        else{
            System.out.println("Invalid selection, exiting terminal");
        }
    }

}