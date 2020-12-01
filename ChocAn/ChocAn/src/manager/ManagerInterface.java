package manager;

import java.util.Scanner;

import reportController.ReportController;
import reportController.memberReportController.MemberReport;

public class ManagerInterface {

    // Private instance of report controller
    private ReportController reportController = new ReportController();
    // path for reports
    private String path = "reports/";

    public ManagerInterface() {
        CLI();
    }

    public void CLI() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.println("1: Produce member report");
        System.out.println("-----------------------------------");

        String choice = scanner.next();
        if (choice.trim().equals("1")) {
            produceMemberReport();
        }
    }

    public void produceMemberReport() {
        String memberNumber = promptForMemberNumber();
        MemberReport memberReport = this.reportController.produceMemberReport(memberNumber);
        if (memberReport.containsServices == true) {
            System.out.println("Member report produced. Do you want to save the report as a file? 1:Yes 2:No");
        } else {
            System.out
                    .println("No services provided to this member. Do you want to save the report anyway? 1:Yes 2:No");
        }
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next().trim();
        if (choice.equals("1")) {

            // This ridiculous looking thing appends the memberNumber to the path as the
            // filename then resets it
            String temp = this.path;
            this.path += memberNumber;
            this.path += ".txt";
            memberReport.writeToTxtFile(this.path);
            this.path = temp;
        }
    }

    /*
     * Helper func used by produceMemberReport
     */
    private String promptForMemberNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter member number: ");
        String response = scanner.next().trim();
        return response;
    }

    public void produceProviderReport() {

    }

    public void produceSummaryReport() {

    }

    private void saveReportToFile(String report) {

    }
}
