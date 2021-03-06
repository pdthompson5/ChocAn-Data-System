package provider;

/**
 * @author Topher Fryzel
 * @author Ben Peinhardt
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import service.serviceOffered.providerDirectory.ProviderDirectory;
import service.serviceOffered.serviceOffered.ServiceOffered;
import service.serviceProvidedPackage.serviceProvidedList.ServiceProvidedList;
import systemUser.Member;
import systemUser.MemberList;
import systemUser.Provider;
import systemUser.ProviderList;

public class ProviderController {

	private MemberList memberList = new MemberList();
	private ProviderList providerList = new ProviderList();
	private ServiceProvidedList serviceProvidedList = new ServiceProvidedList();
	private ProviderDirectory providerDirectory = new ProviderDirectory();

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

	/**
	 * @param memberNumber sees if member is valid
	 * @return boolean verifyMemberStatus
	 */
	public boolean verifyMemberStatus(String memberNumber) {
		Member member = this.memberList.getMember(memberNumber);
		if (member.getMemberStatus() == (true)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Looks up a service in provider directory by code and returns its name
	 * 
	 * @param serviceCode
	 * @return String serviceName
	 */
	public String lookupServiceByCode(String serviceCode) {
		String serviceName = providerDirectory.getServiceByCode(serviceCode).getServiceName();
		return serviceName;
	}

	/**
	 * Looks up a service fee by the service code
	 * 
	 * @param serviceCode
	 * @return double fee
	 */
	public double lookupServicePriceByCode(String serviceCode) {
		double servicePrice = providerDirectory.getServiceByCode(serviceCode).getServiceFee();

		return servicePrice;
	}

	/**
	 * Creates a service provided object and adds it to the ServiceProvidedList
	 * 
	 * @param providerNumber
	 * @param memberNumber
	 * @param serviceDate
	 * @param serviceCode
	 * @param serviceComments
	 */
	public void billChocan(String providerNumber, String memberNumber, String serviceDate, String serviceCode,
			String serviceComments) {

		ServiceOffered myService;
		Member myMember;
		Provider myProvider;
		String currTime = generateDateTime();

		// Find Service
		myService = this.providerDirectory.getServiceByCode(serviceCode);

		// Find Member
		myMember = this.memberList.getMember(memberNumber);

		// Find Provider
		myProvider = this.providerList.getProvider(providerNumber);

		// Add Service Provided
		serviceProvidedList.addServiceProvided(myService, myProvider, myMember, serviceComments, serviceDate, currTime,
				generateUniqueServiceProvidedID());

	}

	private String generateUniqueServiceProvidedID() {
		if (this.serviceProvidedList.getServiceProvidedList().size() == 0) {
			return "100000";
		} else {
			String number = this.serviceProvidedList.getServiceProvidedList()
					.get(this.serviceProvidedList.getServiceProvidedList().size() - 1).getServiceProvidedID();
			Integer num = Integer.parseInt(number);
			num++;
			return Integer.toString(num);
		}
	}

	/**
	 * Uses the Date object to generate a string with the current date and time
	 * 
	 * @return String serviceTime
	 */
	private String generateDateTime() {
		Date todaysDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		return formatter.format(todaysDate);
	}
}
