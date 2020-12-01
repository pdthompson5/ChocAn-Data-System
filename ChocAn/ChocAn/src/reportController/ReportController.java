package reportController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import reportController.eftReportController.EFTData;
import reportController.memberReportController.MemberReport;
import reportController.providerReportController.ProviderReport;
import reportController.summaryReportController.SummaryReport;
import service.serviceProvidedPackage.serviceProvided.ServiceProvided;
import service.serviceProvidedPackage.serviceProvidedList.ServiceProvidedList;

import systemUser.MemberList;
import systemUser.ProviderList;

public class ReportController {

	private ServiceProvidedList listOfServices = new ServiceProvidedList();
	private MemberList memberList = new MemberList();
	private ProviderList providerList = new ProviderList();

	public ReportController() {

	}

	public EFTData produceEFTData() {
		return new EFTData();
	}

	public MemberReport produceMemberReport(String memberNumber) {
		return new MemberReport(listOfServices.getServiceByMember(memberNumber), this.memberList.getMember(memberNumber));
	}

	public ProviderReport produceProviderReport(String providerNumber) {
		return new ProviderReport(listOfServices.getServiceByProvider(providerNumber), this.providerList.getProvider(providerNumber));
	}

	public SummaryReport produceSummaryReport() {
		ArrayList<ServiceProvided> list = listOfServices.getServiceProvidedList();
		list.sort(ServiceProvided.memberNumberComparator);
		return new SummaryReport(listOfServices.getServiceProvidedList());
	}

}
