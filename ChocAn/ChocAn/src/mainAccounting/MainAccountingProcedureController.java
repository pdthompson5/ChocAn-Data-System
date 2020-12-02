package mainAccounting;

import java.io.File;
import java.util.ArrayList;

import reportController.ReportController;
import reportController.memberReportController.MemberReport;
import reportController.providerReportController.ProviderReport;

/**
 * Main Accounting Procedure Controller - Logic for the main accounting
 * procedure. Produces multiple reports for the week
 * 
 * @author Griffin Mack
 */
public class MainAccountingProcedureController {
    private ReportController reportController = new ReportController();
    private String memberPath = "reports/weekly/members/";
    private String providerPath = "reports/weekly/providers/";
    private String eftSummaryPath = "reports/weekly/";

    /**
     * Starts the main accounting procedure
     */
    public void runMainAccountingProcedure() {
        // Clear out all the old files (recursively deletes member and provider files)
        File dir = new File(eftSummaryPath);
        purgeDirectory(dir);

        produceMemberReports();
        produceProviderReports();
        produceSummaryReport();
        produceEFTReport();
    }

    /**
     * Produces a report for each member serviced during the week, and saves the
     * file to the local disk
     */
    private void produceMemberReports() {
        // produce all the member reports
        ArrayList<MemberReport> memberReportList = new ArrayList<MemberReport>();
        memberReportList = reportController.produceAllMemberReports();
        // save all the member reports to their own file
        for (int i = 0; i < memberReportList.size(); i++) {
            memberReportList.get(i).writeToTxtFile(memberPath);
        }
    }

    /**
     * Produces a report for each provider who provided a service during the week,
     * and saves the file to the local disk
     */
    private void produceProviderReports() {
        // produce all the provider reports
        ArrayList<ProviderReport> providerReportList = new ArrayList<ProviderReport>();
        providerReportList = reportController.produceAllProviderReports();
        // save all the member reports to their own file
        for (int i = 0; i < providerReportList.size(); i++) {
            providerReportList.get(i).writeToTxtFile(providerPath);
        }
    }

    /**
     * Produces a report summarizing all the services that were given during the
     * week
     */
    private void produceSummaryReport() {
        reportController.produceSummaryReport().writeToTxtFile(eftSummaryPath);
    }

    /**
     * Produces a report for the electronic funds transfer data for each provider
     * that provided a service during the week
     */
    private void produceEFTReport() {
        reportController.produceEFTData().writeToTxtFile(eftSummaryPath);
    }

    /**
     * Deletes files from a previous run of the main accounting procedure
     * 
     * @param dir the directory from which to delete all files
     */
    private void purgeDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory())
                purgeDirectory(file);
            else
                file.delete();
        }
    }
}
