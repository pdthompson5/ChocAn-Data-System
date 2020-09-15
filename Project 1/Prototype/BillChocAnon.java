
/**
 * Bill ChocAn use case
 */

import java.util.Scanner; // Import the Scanner class
// DONT HAVE TO IMPORT, BUT USES VerifyMemberStatus.java

public class BillChocAnon {
    public BillChocAnon(String memberNumber) {
        // utilize the verifyMemberStatus use case
        VerifyMemberStatus verifyMember = new VerifyMemberStatus(memberNumber);

        String verificationStatus = verifyMember.getVerificationResult();

        String dateOfService = promptForServiceDate();

        String serviceCode = promptForServiceCode();

        verifyServiceCode(serviceCode);

        String serviceComments = promptForServiceComments();

        ProduceReports report = new ProduceReports();

        report.produceBillingReport(memberNumber, dateOfService, serviceCode, serviceComments);

        String billingReport = report.getReport();
        
        String fee = lookUpFeeToBePaid();


    }

    private static String promptForServiceCode() {
        // Prompt the user for the service code
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Please enter service code: ");

        String serviceCode = myObj.nextLine(); // Read user input
        return serviceCode;
    }

    private static void verifyServiceCode(String serviceCode) {
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

    private static String promptForServiceComments() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Please enter any comments about this service: ");

        String serviceComments = myObj.nextLine(); // Read user input
        return serviceComments;

    }

    private static String promptForServiceDate() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Please enter the service date (MM/DD/YYYY): ");

        String dateOfService = myObj.nextLine(); // Read user input
        return dateOfService;
    }

    private static String lookUpFeeToBePaid() {
        // Find the fee that corresponds to the service code
        String fee = "$100.00";
        System.out.println(fee);
        return fee;
    }
}
