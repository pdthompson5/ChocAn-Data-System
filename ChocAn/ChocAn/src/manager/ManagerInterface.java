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
        System.out.println("Member report produced. Do you want to save the report as a file? 1:Yes 2:No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next().trim();
        if (choice.equals("1")) {
            String temp = this.path;
            this.path += memberNumber;
            this.path += ".txt";
            memberReport.writeToTxtFile(this.path);
            this.path = temp;
        }
        
    }

    private String promptForMemberNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter member number: ");
        return scanner.next().trim();
    }

    public void produceProviderReport() {

    }

    public void produceSummaryReport() {

    } 

    private void saveReportToFile(String report) {

    }
}
