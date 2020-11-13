package provider;

import entities.*;
import service.serviceOffered.providerDirectory.ProviderDirectory;
import service.serviceOffered.serviceOffered.ServiceOffered;
import service.serviceProvidedPackage.serviceProvidedList.ServiceProvidedList;
import systemUser.Member;
import systemUser.MemberList;
import systemUser.Provider;
import systemUser.ProviderList;

public class ProviderController {

	public boolean verifyMemberExists(String memberNumber) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean verifyMemberStatus(String memberNumber) {
		// TODO Auto-generated method stub
		return true;
	}

	public String lookupServiceByCode(String serviceCode) {
		// TODO Auto-generated method stub
		return "test_service";
	}

	/**
	 * Creates a service provided object and adds it to the ServiceProvidedList
	 * @param providerNumber
	 * @param memberNumber
	 * @param serviceDate
	 * @param serviceCode
	 * @param serviceComments
	 */
	public void billChocan(String providerNumber, String memberNumber, String serviceDate, String serviceCode,
			String serviceComments) {

		ServiceOffered myService = new ServiceOffered();
		Member myMember = new Member();
		Provider myProvider = new Provider();
		
		// Find Service
		ProviderDirectory myDirectory = new ProviderDirectory();
		myService = myDirectory.getServiceByCode(serviceCode);

		// Find Member
		MemberList myMemberList = new MemberList();
		myMember = myMemberList.getMember(memberNumber);

		// Find Provider
		ProviderList myProviderList = new ProviderList();
		myProvider = myProviderList.getProvider(providerNumber);

		// Add Service Provided
		ServiceProvidedList myServiceProvidedList = new ServiceProvidedList();
		myServiceProvidedList.addServiceProvided(myService, myProvider, myMember, serviceComments);
		
	}
    
}
