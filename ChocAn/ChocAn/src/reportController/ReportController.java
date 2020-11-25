package reportController;

import reportController.eftReportController.EFTData;
import reportController.memberReportController.MemberReport;
import reportController.providerReportController.ProviderReport;
import reportController.summaryReportController.SummaryReport;
import service.serviceProvidedPackage.serviceProvidedList.ServiceProvidedList;

public class ReportController {
	
	private ProviderReport providerReportController;
	private MemberReport memberReportController;
	private SummaryReport summaryReportController;
	private EFTData eftDataController;
	private ServiceProvidedList listOfServices;
	
	
	
	public ReportController(ServiceProvidedList listOfServices) {
		providerReportController = new ProviderReport();
		memberReportController = new MemberReport();
		summaryReportController = new SummaryReport();
		eftDataController = new EFTData();
		this.listOfServices = listOfServices;
	}
	
    public String produceEFTData() {
    	return eftDataController.produceEFTData();
    }
    
    public String produceMemberReport(String memberNumber) {
    	
    	return memberReportController.produceMemberReport(listOfServices.getServiceByMember(memberNumber));
    }
    
    public String produceProviderReport(String providerNumber) {
    	return providerReportController.produceProviderReport(listOfServices.getServiceByProvider(providerNumber));
    }
    
    public String produceSummaryReport() {
    	return summaryReportController.produceSummaryReport(listOfServices.getServiceProvidedList());
    }
    
    
}
