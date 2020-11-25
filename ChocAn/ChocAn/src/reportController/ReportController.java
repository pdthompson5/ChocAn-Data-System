package reportController;

import reportController.eftReportController.EFTData;
import reportController.memberReportController.MemberReport;
import reportController.providerReportController.ProviderReport;
import reportController.summaryReportController.SummaryReport;
import service.serviceProvidedPackage.serviceProvidedList.ServiceProvidedList;

public class ReportController {
	
	private ServiceProvidedList listOfServices;
	
	
	
	public ReportController(ServiceProvidedList listOfServices) {
		this.listOfServices = listOfServices;
	}
	
    public EFTData produceEFTData() {
    	return new EFTData();
    }
    
    public MemberReport produceMemberReport(String memberNumber) {
    	
    	return new MemberReport(listOfServices.getServiceByMember(memberNumber));
    }
    
    public ProviderReport produceProviderReport(String providerNumber) {
    	return new ProviderReport(listOfServices.getServiceByProvider(providerNumber));
    }
    
    public SummaryReport produceSummaryReport() {
    	return new SummaryReport(listOfServices.getServiceProvidedList());
    }
    
    
}
