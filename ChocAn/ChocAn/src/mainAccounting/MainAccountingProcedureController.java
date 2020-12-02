package mainAccounting;

import java.io.File;
import java.util.ArrayList;

import reportController.ReportController;
import reportController.memberReportController.MemberReport;
import reportController.providerReportController.ProviderReport;
import reportController.summaryReportController.SummaryReport;
import reportController.eftReportController.EFTData;

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

    public MainAccountingProcedureController() {
    }

    public void runMainAccountingProcedure() {
        // Clear out all the old files (recursively deletes member and provider files)
        File dir = new File(eftSummaryPath);
        purgeDirectory(dir);

        produceMemberReports();
        produceProviderReports();
        produceSummaryReport();
        produceEFTReport();
    }

    private void produceMemberReports() {
        // produce all the member reports
        ArrayList<MemberReport> memberReportList = new ArrayList<MemberReport>();
        memberReportList = reportController.produceAllMemberReports();
        // save all the member reports to their own file
        for (int i = 0; i < memberReportList.size(); i++) {
            memberReportList.get(i).writeToTxtFile(memberPath);
        }
    }

    private void produceProviderReports() {
        // produce all the provider reports
        ArrayList<ProviderReport> providerReportList = new ArrayList<ProviderReport>();
        providerReportList = reportController.produceAllProviderReports();
        // save all the member reports to their own file
        for (int i = 0; i < providerReportList.size(); i++) {
            providerReportList.get(i).writeToTxtFile(providerPath);
        }
    }

    private void produceSummaryReport() {
        reportController.produceSummaryReport().writeToTxtFile(eftSummaryPath);
    }

    private void produceEFTReport() {
        reportController.produceEFTData().writeToTxtFile(eftSummaryPath);
    }

    private void purgeDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory())
                purgeDirectory(file);
            else
                file.delete();
        }
    }
}
