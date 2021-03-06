package manager;

import java.security.Provider;
import java.util.Scanner;

import reportController.ReportController;
import reportController.memberReportController.MemberReport;
import reportController.providerReportController.ProviderReport;
import reportController.summaryReportController.SummaryReport;

/**
 * @author Ben Peinhardt
 * @author Griffin Mack
 */
public class ManagerInterface {

    // Private instance of report controller
    private ReportController reportController = new ReportController();
    // path for reports
    private String memberPath = "src/reports/manager/members/";
    private String providerPath = "src/reports/manager/providers/";
    private String summaryPath = "src/reports/manager/";
    private boolean exitMenu = false;

    /**
     * Launches the command line interface for the manager terminal. Will be
     * replaced by gui
     */
    public ManagerInterface() {
        managerMainMenu();
    }

    /**
     * Command Line Interface with managers options
     */
    public void managerMainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (!exitMenu) {
            System.out.println("---------------------------------");
            System.out.println("1: Produce member report");
            System.out.println("2: Produce provider report");
            System.out.println("3: Produce summary report");
            System.out.println("<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>");
            System.out.println("4. Exit");
            System.out.println("---------------------------------");
            System.out.print("Please choose from the above options: ");

            String choice = scanner.next();
            if (choice.trim().equals("1")) {
                produceMemberReport();
            } else if (choice.trim().equals("2")) {
                produceProviderReport();
            } else if(choice.trim().equals("3")) {
            	produceSummaryReport();
        	}else if (choice.trim().equals("4")) {
                System.out.println("Exiting manager menu");
                exitMenu = true;
            } else {
                System.out.println("Invalid selection, please choose option between 1-4");
            }
        }
    }

    /**
     * Produces a member report given a member number and gives the option to save
     * the report
     */
    public void produceMemberReport() {
        String memberNumber = promptForMemberNumber();
        if (!verifyMember(memberNumber))
            return;
        MemberReport memberReport = this.reportController.produceMemberReport(memberNumber);
        if (memberReport.containsServices == true) {
            System.out.println("Member report produced. Do you want to save the report as a file? 1:Yes 2:No");
        } else {
            System.out.println("No services provided to this member. Do you want to save the report anyway? 1:Yes 2:No");
        }
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next().trim();
            if (choice.equals("1")) {
                memberReport.writeToTxtFile(this.memberPath);
                break;
            } else if (choice.equals("2")) {
                break;
            } else {
                System.out.println("Invalid input: please enter a 1 or a 2: ");
            }
        }
    }

    /*
     * Helper func used by produceMemberReport
     */
    private String promptForMemberNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter member number: ");
        String response = scanner.next().trim();
        return response;
    }
     /**
     * Produces a provider report given a provider number and gives the option to save
     * the report
     */
    public void produceProviderReport() {
        String providerNumber = promptForProviderNumber();
        if (!verifyMember(providerNumber))
            return;
        ProviderReport providerReport = this.reportController.produceProviderReport(providerNumber);
        if (providerReport.containsServices) {
            System.out.print("Provider report produced. Do you want to save the report as a file? 1:Yes 2:No");
        } else {
            System.out.print(
                    "No services were billed by this provider. Do you want to save the report anyway? 1:Yes 2:No");
        }

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next().trim();
        if (choice.equals("1")) {
            providerReport.writeToTxtFile(this.providerPath);
        }

    }

    /*
     * Helper function used by produceProviderReport
     */
    private String promptForProviderNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter provider number: ");
        String response = scanner.next().trim();
        return response;
    }
    
     /**
     * Produces a summary report and gives the option to save the report
     */
    public void produceSummaryReport() {
    	SummaryReport summaryReport = this.reportController.produceSummaryReport();
    	System.out.print("Summary report produced. Do you want to save the report as a file? 1:Yes 2:No");
    	Scanner scanner = new Scanner(System.in);
        String choice = scanner.next().trim();
        if (choice.equals("1")) {
            summaryReport.writeToTxtFile(this.summaryPath);
        }
    }

    /**
     * Verifies a member number exists
     * 
     * @param memberNumber
     * @return boolean
     */
    public boolean verifyMember(String memberNumber) {
        boolean memberExists = reportController.verifyMemberExists(memberNumber);
        if (!memberExists) {
            System.out.println("Invalid member number! Member does not exist. Returning to menu");
            return false;
        }
        return true;
    }

    /**
     * Verifies a provider number exists
     * 
     * @param providerNumber
     * @return boolean
     */
    public boolean verifyProvider(String providerNumber) {
        boolean providerExists = reportController.verifyProviderExists(providerNumber);
        if (!providerExists) {
            System.out.println("Invalid provider number! Provider does not exist. Returning to menu");
            return false;
        }
        return true;
    }
}
