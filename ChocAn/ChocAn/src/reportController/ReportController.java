package reportController;

import reportController.eftReportController.EFTDataController;
import reportController.memberReportController.MemberReportController;
import reportController.providerReportController.ProviderReportController;
import reportController.summaryReportController.SummaryReportController;
import service.serviceProvidedPackage.serviceProvidedList.ServiceProvidedList;

public class ReportController {
	
	private ProviderReportController providerReportController;
	private MemberReportController memberReportController;
	private SummaryReportController summaryReportController;
	private EFTDataController eftDataController;
	private ServiceProvidedList listOfServices;
	
	
	
	public ReportController(ServiceProvidedList listOfServices) {
		providerReportController = new ProviderReportController();
		memberReportController = new MemberReportController();
		summaryReportController = new SummaryReportController();
		eftDataController = new EFTDataController();
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
