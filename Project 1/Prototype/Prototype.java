
/**
 * prototype
 */
import java.util.Scanner; // Import the Scanner class
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prototype {

    public static String promptForMemberNumber() {
        // Prompt the user for the member number
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Please enter member number: ");

        String memberNumber = myObj.nextLine(); // Read user input
        return memberNumber;
    }

    public static void verifyMemberNumber(String memberNumber) {
        // Given a member number, check if the member is valid or not
        String validMember = "Validated";
        String invalidMember = "Invalid or Suspended";
    }

    public static String promptForServiceCode() {
        // Prompt the user for the service code
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Please enter service code: ");

        String serviceCode = myObj.nextLine(); // Read user input
        return serviceCode;
    }

    public static void verifyServiceCode(String serviceCode) {
        // Find the service code, and ask for verification from the user

        // Search through a list of service codes
        String serviceName = "example Service Name";

        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Service name: " + serviceName + " Correct? Enter 'YES' or 'NO' ");

        String serviceNameValidation = myObj.nextLine(); // Read user input

        if (serviceNameValidation == "NO") {
            System.out.println("ERROR, exiting terminal");
            System.exit(0);
        }
    }

    public static String promptForServiceComments() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Please enter any comments about this service: ");

        String serviceComments = myObj.nextLine(); // Read user input
        return serviceComments;

    }

    public static String promptForServiceDate() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Please enter the service date (MM/DD/YYYY): ");

        String dateOfService = myObj.nextLine(); // Read user input
        return dateOfService;
    }

    public static String createServiceRecord(String memberNumber, String dateOfService, String serviceCode,
            String serviceComments) {
        // grab the current date and time
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String currentDate = formatter.format(date);

        // Create a record and save it to a file
        String serviceRecord = "Current date and time: " + currentDate + "\n";
        serviceRecord += "Date service was provided: " + dateOfService + "\n";
        serviceRecord += "Provider number: " + "notImplemented.." + "\n";
        serviceRecord += "Member number: " + memberNumber + "\n";
        serviceRecord += "Service code: " + serviceCode + "\n";
        serviceRecord += "Comments: " + serviceComments + "\n";

        return serviceRecord;

    }

    public static void main(String[] args) {
        String memberNumber = promptForMemberNumber();

        verifyMemberNumber(memberNumber);

        String dateOfService = promptForServiceDate();

        String serviceCode = promptForServiceCode();

        verifyServiceCode(serviceCode);

        String serviceComments = promptForServiceComments();

        String serviceRecord = createServiceRecord(memberNumber, dateOfService, serviceCode, serviceComments);

        System.out.println("\n" + serviceRecord);
    }

}