package controllers;

import entities.Member;
import entities.Provider;
import entities.ServiceProvidedList;

public class ReportController {
	
	private ProviderReportController providerReportController = new ProviderReportController();
	private MemberReportController memberReportController = new MemberReportController();
	private SummaryReportController summaryReportController = new SummaryReportController();
	private EFTDataController eftDataController = new EFTDataController();
	
	
	
    public String produceEFTData() {
    	return eftDataController.produceEFTData();
    }
    
    public String produceMemberReport() {
    	return memberReportController.produceMemberReport(new Member());
    }
    
    public String produceProviderReport() {
    	return providerReportController.produceProviderReport(new Provider());
    }
    
    
}
