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

import systemUser.Member;
import systemUser.MemberList;
import systemUser.Provider;
import systemUser.ProviderList;

public class ReportController {

	private ServiceProvidedList listOfServices = new ServiceProvidedList();
	private MemberList memberList = new MemberList();
	private ProviderList providerList = new ProviderList();

	public ReportController() {

	}

	public EFTData produceEFTData(String providerNumber) {
		return new EFTData(listOfServices.getServiceByProvider(providerNumber));
	}

	public MemberReport produceMemberReport(String memberNumber) {
		return new MemberReport(listOfServices.getServiceByMember(memberNumber),
				this.memberList.getMember(memberNumber));
	}

	/**
	 * Produces a member report for each unique member serviced during the week
	 * 
	 * @return ArrayList<MemberReport> memberReportList
	 */
	public ArrayList<MemberReport> produceAllMemberReports() {
		ArrayList<MemberReport> memberReportList = new ArrayList<MemberReport>();
		ArrayList<Member> memberList = listOfServices.getWeeklyMembers();
		for (int i = 0; i < memberList.size(); i++) {
			memberReportList.add(produceMemberReport(memberList.get(i).getMemberNumber()));
		}
		return memberReportList;
	}

	public ProviderReport produceProviderReport(String providerNumber) {
		return new ProviderReport(listOfServices.getServiceByProvider(providerNumber),
				this.providerList.getProvider(providerNumber));
	}

	/**
	 * Produces a provider report for each unique provider who provided a service
	 * during the week
	 * 
	 * @return ArrayList<ProviderReport> providerReportList
	 */
	public ArrayList<ProviderReport> produceAllProviderReports() {
		ArrayList<ProviderReport> providerReportList = new ArrayList<ProviderReport>();
		ArrayList<Provider> providerList = listOfServices.getWeeklyProviders();
		for (int i = 0; i < providerList.size(); i++) {
			providerReportList.add(produceProviderReport(providerList.get(i).getProviderNumber()));
		}
		return providerReportList;
	}

	public SummaryReport produceSummaryReport() {
		ArrayList<ServiceProvided> list = listOfServices.getServiceProvidedList();
		list.sort(ServiceProvided.providerNumberComparator);
		return new SummaryReport(listOfServices.getServiceProvidedList());
	}

	/**
	 * @param memberNumber sees if member is in the file
	 * @return boolean verifyMemberExists
	 */
	public boolean verifyMemberExists(String memberNumber) {
		Member member = this.memberList.getMember(memberNumber);
		if (member.getMemberNumber().equals("0")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param providerNumber sees if provider is in the file
	 * @return boolean verifyProviderExists
	 */
	public boolean verifyProviderExists(String providerNumber) {
		Provider provider = this.providerList.getProvider(providerNumber);
		if (provider.getProviderNumber().equals("0")) {
			return false;
		} else {
			return true;
		}
	}

}
